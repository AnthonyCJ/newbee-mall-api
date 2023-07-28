package ltd.newbee.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商城用户地址实体类，用于存储商城用户地址的相关信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * 商城用户地址实体类包含了商城用户地址的各个属性，包括地址ID、用户ID、
 * 收件人姓名、收件人手机号、是否默认地址标识等信息，同时还包含了省份、城市、
 * 区域名称、详细地址等信息，以及是否已删除、创建时间和更新时间等信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 21:10
 */
@Data
public class MallUserAddress {
    // 地址ID
    private Long addressId;

    // 用户ID
    private Long userId;

    // 收件人姓名
    private String userName;

    // 收件人手机号
    private String userPhone;

    // 是否默认地址标识（0：非默认地址，1：默认地址）
    private Byte defaultFlag;

    // 省份名称
    private String provinceName;

    // 城市名称
    private String cityName;

    // 区域名称
    private String regionName;

    // 详细地址
    private String detailAddress;

    // 是否已删除（0：未删除，1：已删除）
    private Byte isDeleted;

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;
}
