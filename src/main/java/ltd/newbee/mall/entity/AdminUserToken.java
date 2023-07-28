package ltd.newbee.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 管理员用户Token表实体类，用于存储管理员用户的登录Token信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * 管理员用户Token表实体类包含了管理员用户的登录Token信息，包括管理员用户ID、
 * Token值、Token更新时间和Token过期时间等信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/28 19:26
 */
@Data
public class AdminUserToken {
    // 管理员用户ID
    private Long adminUserId;

    // Token值
    private String token;

    // Token更新时间
    private Date updateTime;

    // Token过期时间
    private Date expireTime;
}
