package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * NewBeeMall订单实体类，用于存储订单的相关信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * NewBeeMall订单实体类包含了订单的各个属性，包括订单ID、订单编号、用户ID、
 * 总价格、支付状态、支付类型、支付时间、订单状态、额外信息、是否已删除、
 * 创建时间和更新时间等信息。
 *
 * 注意：该实体类使用了com.fasterxml.jackson.annotation.JsonFormat注解，
 * 用于在JSON序列化时对日期属性进行格式化，时区设为GMT+8，格式为"yyyy-MM-dd HH:mm:ss"。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 22:02
 */
@Data
public class NewBeeMallOrder {
    // 订单ID
    private Long orderId;

    // 订单编号
    private String orderNo;

    // 用户ID
    private Long userId;

    // 总价格
    private Integer totalPrice;

    // 支付状态（0：未支付，1：已支付）
    private Byte payStatus;

    // 支付类型
    private Byte payType;

    // 支付时间
    private Date payTime;

    // 订单状态
    private Byte orderStatus;

    // 额外信息
    private String extraInfo;

    // 是否已删除（0：未删除，1：已删除）
    private Byte isDeleted;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
