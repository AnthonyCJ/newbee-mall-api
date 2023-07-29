package ltd.newbee.mall.api.mall.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 保存订单param
 * @date 2023/07/29 15:16
 */
@Data
public class SaveOrderParam implements Serializable {

    @ApiModelProperty("订单项id数组")
    private Long[] cartItemIds;

    @ApiModelProperty("地址id")
    private Long addressId;
}
