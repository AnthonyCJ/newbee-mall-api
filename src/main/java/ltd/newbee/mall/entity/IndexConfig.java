package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 首页配置实体类，用于存储首页配置相关信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成getter、setter方法等。
 *
 * 首页配置实体类包含了首页配置的各个属性，包括配置ID、配置名称、配置类型、
 * 商品ID、跳转链接URL、配置排序等信息，同时还包含了创建时间、创建者、更新时间和更新者等信息。
 *
 * 注：该实体类使用了com.fasterxml.jackson.annotation.JsonFormat注解，
 * 用于在JSON序列化时对日期属性进行格式化，时区设为GMT+8，格式为"yyyy-MM-dd HH:mm:ss"。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 20:54
 */
@Data
public class IndexConfig {
    // 配置ID
    private Long configId;

    // 配置名称
    private String configName;

    // 配置类型（1：轮播图，2：导航栏，3：推荐商品）
    private Byte configType;

    // 商品ID（仅当配置类型为推荐商品时有效）
    private Long goodsId;

    // 跳转链接URL
    private String redirectUrl;

    // 配置排序
    private Integer configRank;

    // 是否已删除（0：未删除，1：已删除）
    private Byte isDeleted;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    // 创建者ID
    private Integer createUser;

    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    // 更新者ID
    private Integer updateUser;
}
