/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2021 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
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
