package ltd.newbee.mall.entity;

import lombok.Data;

/**
 * 商城管理员实体类，用于存储商城管理员的信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * 商城管理员实体类包含了商城管理员的各个属性，包括管理员ID、登录用户名、
 * 登录密码、昵称和账号是否被锁定等信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 19:24
 */
@Data
public class AdminUser {
    // 管理员ID
    private Long adminUserId;

    // 登录用户名
    private String loginUserName;

    // 登录密码
    private String loginPassword;

    // 昵称
    private String nickName;

    // 账号是否被锁定（0：未锁定，1：已锁定）
    private Byte locked;
}
