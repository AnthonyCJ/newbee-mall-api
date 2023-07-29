package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.api.mall.param.MallUserUpdateParam;
import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.MallUserMapper;
import ltd.newbee.mall.dao.NewBeeMallUserTokenMapper;
import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.entity.MallUserToken;
import ltd.newbee.mall.service.NewBeeMallUserService;
import ltd.newbee.mall.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户管理服务实现类
 *
 * 该类实现了NewBeeMallUserService接口，提供了对用户数据的增删改查等功能。
 *
 * @author AnthonyCJ
 * @Autowired 用于自动装配MallUserMapper和NewBeeMallUserTokenMapper，实现对用户和用户token表的操作。
 * @Service 用于标识该类是一个服务层组件，将其作为Spring容器中的Bean进行管理。
 */
@Service
public class NewBeeMallUserServiceImpl implements NewBeeMallUserService {

    @Autowired
    private MallUserMapper mallUserMapper;
    @Autowired
    private NewBeeMallUserTokenMapper newBeeMallUserTokenMapper;

    /**
     * 用户注册
     *
     * @param loginName 用户名
     * @param password 密码
     * @return 注册结果，返回"SUCCESS"表示注册成功，"SAME_LOGIN_NAME_EXIST"表示用户名已存在，
     *         "DB_ERROR"表示数据库操作失败。
     */
    @Override
    public String register(String loginName, String password) {
        if (mallUserMapper.selectByLoginName(loginName) != null) {
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }
        MallUser registerUser = new MallUser();
        registerUser.setLoginName(loginName);
        registerUser.setNickName(loginName);
        registerUser.setIntroduceSign(Constants.USER_INTRO);
        String passwordMD5 = MD5Util.MD5Encode(password, "UTF-8");
        registerUser.setPasswordMd5(passwordMD5);
        if (mallUserMapper.insertSelective(registerUser) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    /**
     * 用户登录
     *
     * @param loginName 用户名
     * @param passwordMD5 加密后的密码
     * @return 登录结果，返回登录成功后生成的token字符串，"LOGIN_USER_LOCKED_ERROR"表示用户被锁定，
     *         "LOGIN_ERROR"表示登录失败。
     */
    @Override
    public String login(String loginName, String passwordMD5) {
        MallUser user = mallUserMapper.selectByLoginNameAndPasswd(loginName, passwordMD5);
        if (user != null) {
            if (user.getLockedFlag() == 1) {
                return ServiceResultEnum.LOGIN_USER_LOCKED_ERROR.getResult();
            }
            // 登录后即执行修改token的操作
            String token = getNewToken(System.currentTimeMillis() + "", user.getUserId());
            MallUserToken mallUserToken = newBeeMallUserTokenMapper.selectByPrimaryKey(user.getUserId());
            // 当前时间
            Date now = new Date();
            // 过期时间
            Date expireTime = new Date(now.getTime() + 2 * 24 * 3600 * 1000);//过期时间 48 小时
            if (mallUserToken == null) {
                mallUserToken = new MallUserToken();
                mallUserToken.setUserId(user.getUserId());
                mallUserToken.setToken(token);
                mallUserToken.setUpdateTime(now);
                mallUserToken.setExpireTime(expireTime);
                // 新增一条token数据
                if (newBeeMallUserTokenMapper.insertSelective(mallUserToken) > 0) {
                    // 新增成功后返回
                    return token;
                }
            } else {
                mallUserToken.setToken(token);
                mallUserToken.setUpdateTime(now);
                mallUserToken.setExpireTime(expireTime);
                //更新
                if (newBeeMallUserTokenMapper.updateByPrimaryKeySelective(mallUserToken) > 0) {
                    //修改成功后返回
                    return token;
                }
            }

        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

    /**
     * 获取新的token值
     *
     * @param timeStr 时间戳字符串
     * @param userId 用户ID
     * @return 新的token值
     */
    private String getNewToken(String timeStr, Long userId) {
        String src = timeStr + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);
    }

    /**
     * 更新用户信息
     *
     * @param mallUser 用户信息
     * @param userId 用户ID
     * @return 更新成功返回true，否则返回false。
     */
    @Override
    public Boolean updateUserInfo(MallUserUpdateParam mallUser, Long userId) {
        MallUser user = mallUserMapper.selectByPrimaryKey(userId);
        if (user == null) {
            NewBeeMallException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        user.setNickName(mallUser.getNickName());
        // user.setPasswordMd5(mallUser.getPasswordMd5());
        // 若密码为空字符，则表明用户不打算修改密码，使用原密码保存
        if (!MD5Util.MD5Encode("", "UTF-8").equals(mallUser.getPasswordMd5())){
            user.setPasswordMd5(mallUser.getPasswordMd5());
        }
        user.setIntroduceSign(mallUser.getIntroduceSign());
        if (mallUserMapper.updateByPrimaryKeySelective(user) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 用户注销
     *
     * @param userId 用户ID
     * @return 注销成功返回true，否则返回false。
     */
    @Override
    public Boolean logout(Long userId) {
        return newBeeMallUserTokenMapper.deleteByPrimaryKey(userId) > 0;
    }

    /**
     * 获取用户分页数据
     *
     * @param pageUtil 分页查询对象
     * @return 用户分页结果
     */
    @Override
    public PageResult getNewBeeMallUsersPage(PageQueryUtil pageUtil) {
        List<MallUser> mallUsers = mallUserMapper.findMallUserList(pageUtil);
        int total = mallUserMapper.getTotalMallUsers(pageUtil);
        PageResult pageResult = new PageResult(mallUsers, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    /**
     * 批量锁定或解锁用户
     *
     * @param ids 用户ID数组
     * @param lockStatus 锁定状态，1表示锁定，0表示解锁
     * @return 操作成功返回true，否则返回false。
     */
    @Override
    public Boolean lockUsers(Long[] ids, int lockStatus) {
        if (ids.length < 1) {
            return false;
        }
        return mallUserMapper.lockUserBatch(ids, lockStatus) > 0;
    }
}
