package ltd.newbee.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * NewBeeMall订单项实体类，用于存储订单的商品项信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * NewBeeMall订单项实体类包含了订单项的各个属性，包括订单项ID、订单ID、
 * 商品ID、商品名称、商品封面图片、销售价格、商品数量和创建时间等信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 22:29
 */
@Data
public class NewBeeMallOrderItem {
    // 订单项ID
    private Long orderItemId;

    // 订单ID
    private Long orderId;

    // 商品ID
    private Long goodsId;

    // 商品名称
    private String goodsName;

    // 商品封面图片
    private String goodsCoverImg;

    // 销售价格
    private Integer sellingPrice;

    // 商品数量
    private Integer goodsCount;

    // 创建时间
    private Date createTime;
}