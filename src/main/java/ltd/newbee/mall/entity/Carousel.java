package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 轮播图实体类，用于存储轮播图相关信息。
 *
 * 该实体类使用了Lombok的@Data注解，将自动生成getter、setter等方法。
 *
 * 轮播图实体类包含了轮播图的各个属性，包括轮播图ID、轮播图URL、跳转链接URL、
 * 轮播图排序等信息，同时还包含了创建时间、创建者、更新时间和更新者等信息。
 *
 * 注：该实体类使用了com.fasterxml.jackson.annotation.JsonFormat注解，
 * 用于在JSON序列化时对日期属性进行格式化，时区设为GMT+8，格式为"yyyy-MM-dd HH:mm:ss"。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 20:27
 */
@Data
public class Carousel {
    // 轮播图ID
    private Integer carouselId;

    // 轮播图URL
    private String carouselUrl;

    // 跳转链接URL
    private String redirectUrl;

    // 轮播图排序
    private Integer carouselRank;

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
