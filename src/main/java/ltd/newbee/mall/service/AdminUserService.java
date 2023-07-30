package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.AdminUser;

/**
 * 商城管理员服务层接口
 *
 * @author GnayYzal
 * @version 1.0
 * @date 2023/07/29 16:14
 */
public interface AdminUserService {

    /**
     * 登录
     * @param userName 登录名
     * @param password 密码
     * @return 一个登录成功生成或修改的token或一个登录错误的字符串
     */
    String login(String userName, String password);

    /**
     * 获取用户信息
     *
     * @param loginUserId 登录用户id
     * @return 包含管理员详细信息的AdminUser对象，或者是null（如果找不到对应的用户记录）
     */
    AdminUser getUserDetailById(Long loginUserId);

    /**
     * 修改当前登录用户的密码
     *
     * @param loginUserId 登录用户id
     * @param originalPassword 用户原始密码
     * @param newPassword 用户新密码
     * @return true（修改成功）或false（修改失败）。
     */
    Boolean updatePassword(Long loginUserId, String originalPassword, String newPassword);

    /**
     * 修改当前登录用户的名称信息
     *
     * @param loginUserId 登录用户id
     * @param loginUserName 登录用户名
     * @param nickName 昵称
     * @return true（修改成功）或false（修改失败）。
     */
    Boolean updateName(Long loginUserId, String loginUserName, String nickName);

    /**
     * 注销
     * @param adminUserId 管理员id
     * @return true（注销成功）或false（注销失败）。
     */
    Boolean logout(Long adminUserId);


}
