package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 商城用户实体类，用于存储商城用户的相关信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * 商城用户实体类包含了商城用户的各个属性，包括用户ID、昵称、登录名、
 * 经过MD5加密的密码、个性签名等信息，同时还包含了是否已删除、是否被锁定的标识，
 * 以及创建时间等信息。
 *
 * 注：该实体类使用了com.fasterxml.jackson.annotation.JsonFormat注解，
 * 用于在JSON序列化时对日期属性进行格式化，时区设为GMT+8，格式为"yyyy-MM-dd HH:mm:ss"。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 20:59
 */
@Data
public class MallUser {
    // 用户ID
    private Long userId;

    // 用户昵称
    private String nickName;

    // 用户登录名
    private String loginName;

    // 经过MD5加密的用户密码
    private String passwordMd5;

    // 个性签名
    private String introduceSign;

    // 是否已删除（0：未删除，1：已删除）
    private Byte isDeleted;

    // 是否被锁定（0：未锁定，1：已锁定）
    private Byte lockedFlag;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
