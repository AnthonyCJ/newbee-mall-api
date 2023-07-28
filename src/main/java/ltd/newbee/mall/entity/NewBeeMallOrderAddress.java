package ltd.newbee.mall.entity;

import lombok.Data;

/**
 * NewBeeMall订单地址实体类，用于存储订单的收货地址信息。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * NewBeeMall订单地址实体类包含了订单的收货地址信息，包括订单ID、收货人姓名、
 * 收货人电话、省份名称、城市名称、区域名称和详细地址等信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 22:15
 */
@Data
public class NewBeeMallOrderAddress {
    // 订单ID
    private Long orderId;

    // 收货人姓名
    private String userName;

    // 收货人电话
    private String userPhone;

    // 省份名称
    private String provinceName;

    // 城市名称
    private String cityName;

    // 区域名称
    private String regionName;

    // 详细地址
    private String detailAddress;
}
