/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2021 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.AdminUserMapper;
import ltd.newbee.mall.dao.NewBeeAdminUserTokenMapper;
import ltd.newbee.mall.entity.AdminUser;
import ltd.newbee.mall.entity.AdminUserToken;
import ltd.newbee.mall.service.AdminUserService;
import ltd.newbee.mall.util.NumberUtil;
import ltd.newbee.mall.util.SystemUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 管理员管理实现类
 *
 * 该类实现了AdminUserService接口，提供了对管理员管理等功能。
 *
 * @author GnayYzal
 * @Service 用于标识该类是一个服务层组件，将其作为Spring容器中的Bean进行管理。
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private NewBeeAdminUserTokenMapper newBeeAdminUserTokenMapper;

    /**
     * 登录
     * @param userName 登录名
     * @param password 密码
     * @return 一个登录成功生成或修改的token或一个登录错误的字符串
     */
    @Override
    public String login(String userName, String password) {
        AdminUser loginAdminUser = adminUserMapper.login(userName, password);
        if (loginAdminUser != null) {
            //登录后即执行修改token的操作
            String token = getNewToken(System.currentTimeMillis() + "", loginAdminUser.getAdminUserId());
            AdminUserToken adminUserToken = newBeeAdminUserTokenMapper.selectByPrimaryKey(loginAdminUser.getAdminUserId());
            //当前时间
            Date now = new Date();
            //过期时间
            Date expireTime = new Date(now.getTime() + 2 * 24 * 3600 * 1000);//过期时间 48 小时
            if (adminUserToken == null) {
                adminUserToken = new AdminUserToken();
                adminUserToken.setAdminUserId(loginAdminUser.getAdminUserId());
                adminUserToken.setToken(token);
                adminUserToken.setUpdateTime(now);
                adminUserToken.setExpireTime(expireTime);
                //新增一条token数据
                if (newBeeAdminUserTokenMapper.insertSelective(adminUserToken) > 0) {
                    //新增成功后返回
                    return token;
                }
            } else {
                adminUserToken.setToken(token);
                adminUserToken.setUpdateTime(now);
                adminUserToken.setExpireTime(expireTime);
                //更新
                if (newBeeAdminUserTokenMapper.updateByPrimaryKeySelective(adminUserToken) > 0) {
                    //修改成功后返回
                    return token;
                }
            }

        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }


    /**
     * 获取token值
     *
     * @param timeStr 生成令牌(token)的时间戳
     * @param userId 用户id
     * @return 一个字符串（生成的令牌）
     */
    private String getNewToken(String timeStr, Long userId) {
        String src = timeStr + userId + NumberUtil.genRandomNum(6);
        return SystemUtil.genToken(src);
    }

    /**
     * 获取管理员信息
     *
     * @param loginUserId 登录用户id
     * @return 包含管理员详细信息的AdminUser对象
     */
    @Override
    public AdminUser getUserDetailById(Long loginUserId) {
        return adminUserMapper.selectByPrimaryKey(loginUserId);
    }

    /**
     * 修改当前登录用户的密码
     *
     * @param loginUserId 登录用户id
     * @param originalPassword 用户原始密码
     * @param newPassword 用户新密码
     * @return 修改成功且清空当前token则返回true，否则返回false
     */
    @Override
    public Boolean updatePassword(Long loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //比较原密码是否正确
            if (originalPassword.equals(adminUser.getLoginPassword())) {
                //设置新密码并修改
                adminUser.setLoginPassword(newPassword);
                if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0 && newBeeAdminUserTokenMapper.deleteByPrimaryKey(loginUserId) > 0) {
                    //修改成功且清空当前token则返回true
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 修改当前登录用户的名称信息
     *
     * @param loginUserId 登录用户id
     * @param loginUserName 登录用户名
     * @param nickName 昵称
     * @return true（修改成功）或false（修改失败）。
     */
    @Override
    public Boolean updateName(Long loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //设置新名称并修改
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }

    /**
     * 注销
     *
     * @param adminUserId 管理员ID
     * @return 注销成功返回true，否则返回false。
     */
    @Override
    public Boolean logout(Long adminUserId) {
        return newBeeAdminUserTokenMapper.deleteByPrimaryKey(adminUserId) > 0;
    }
}
