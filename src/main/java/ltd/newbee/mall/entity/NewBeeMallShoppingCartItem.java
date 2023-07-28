package ltd.newbee.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * NewBeeMall购物车商品项实体类，用于存储用户购物车中的商品项信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * NewBeeMall购物车商品项实体类包含了购物车商品项的各个属性，包括购物车商品项ID、
 * 用户ID、商品ID、商品数量、是否已删除、创建时间和更新时间等信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 22:54
 */
@Data
public class NewBeeMallShoppingCartItem {
    // 购物车商品项ID
    private Long cartItemId;

    // 用户ID
    private Long userId;

    // 商品ID
    private Long goodsId;

    // 商品数量
    private Integer goodsCount;

    // 是否已删除（0：未删除，1：已删除）
    private Byte isDeleted;

    // 创建时间
    private Date createTime;

    // 更新时间
    private Date updateTime;
}
