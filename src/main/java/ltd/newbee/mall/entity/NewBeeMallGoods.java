package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * NewBeeMall商品实体类，用于存储商品的相关信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * NewBeeMall商品实体类包含了商品的各个属性，包括商品ID、商品名称、商品简介、
 * 商品分类ID、商品封面图片、商品轮播图、原始价格、销售价格、库存数量、标签、
 * 商品销售状态、创建者ID、创建时间、更新者ID和更新时间等信息，还包含了商品详情内容。
 *
 * 注：该实体类使用了com.fasterxml.jackson.annotation.JsonFormat注解，
 * 用于在JSON序列化时对日期属性进行格式化，时区设为GMT+8，格式为"yyyy-MM-dd HH:mm:ss"。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 21:31
 */
@Data
public class NewBeeMallGoods {
    // 商品ID
    private Long goodsId;

    // 商品名称
    private String goodsName;

    // 商品简介
    private String goodsIntro;

    // 商品分类ID
    private Long goodsCategoryId;

    // 商品封面图片
    private String goodsCoverImg;

    // 商品轮播图
    private String goodsCarousel;

    // 原始价格
    private Integer originalPrice;

    // 销售价格
    private Integer sellingPrice;

    // 库存数量
    private Integer stockNum;

    // 标签
    private String tag;

    // 商品销售状态（0：下架，1：上架）
    private Byte goodsSellStatus;

    // 创建者ID
    private Integer createUser;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    // 更新者ID
    private Integer updateUser;

    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    // 商品详情内容
    private String goodsDetailContent;
}
