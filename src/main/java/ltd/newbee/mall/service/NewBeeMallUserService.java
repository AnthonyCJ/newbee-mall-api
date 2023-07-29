package ltd.newbee.mall.service;

import ltd.newbee.mall.api.mall.param.MallUserUpdateParam;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

/**
 * 商城用户服务层接口
 *
 * 该接口定义了商城用户相关的服务方法，包括用户注册、登录、用户信息修改、登出、用户禁用与解除禁用等功能。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/29 14:39
 */
public interface NewBeeMallUserService {

    /**
     * 用户注册
     *
     * @param loginName 登录名
     * @param password 密码
     * @return 注册结果信息，包含注册成功、相同登录名已存在或数据库错误等状态
     */
    String register(String loginName, String password);

    /**
     * 用户登录
     *
     * @param loginName 登录名
     * @param passwordMD5 经过MD5加密的密码
     * @return 登录结果，返回登录成功后生成的用户令牌(Token)
     */
    String login(String loginName, String passwordMD5);

    /**
     * 修改用户信息
     *
     * @param mallUser 用户信息对象
     * @param userId 用户ID
     * @return 修改结果，修改成功返回true，否则返回false
     */
    Boolean updateUserInfo(MallUserUpdateParam mallUser, Long userId);

    /**
     * 用户登出
     *
     * @param userId 用户ID
     * @return 登出成功返回true，否则返回false
     */
    Boolean logout(Long userId);

    /**
     * 用户禁用与解除禁用
     *
     * @param ids 用户ID数组
     * @param lockStatus 锁定状态，0表示未锁定，1表示已锁定
     * @return 操作结果，禁用/解除禁用成功返回true，否则返回false
     */
    Boolean lockUsers(Long[] ids, int lockStatus);

    /**
     * 后台分页查询用户列表
     *
     * @param pageUtil 分页查询工具类
     * @return 分页查询结果，包含用户列表及总记录数等信息
     */
    PageResult getNewBeeMallUsersPage(PageQueryUtil pageUtil);
}
