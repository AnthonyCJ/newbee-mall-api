package ltd.newbee.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商城用户令牌实体类，用于存储商城用户的登录令牌相关信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * 商城用户令牌实体类包含了商城用户的令牌信息，包括用户ID、登录令牌、
 * 更新时间和过期时间等信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 21:20
 */
@Data
public class MallUserToken {
    // 用户ID
    private Long userId;

    // 登录令牌
    private String token;

    // 更新时间
    private Date updateTime;

    // 过期时间
    private Date expireTime;
}
