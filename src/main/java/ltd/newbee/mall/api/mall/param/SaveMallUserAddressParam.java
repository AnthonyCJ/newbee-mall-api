package ltd.newbee.mall.api.mall.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 添加收货地址param
 * @date 2023/07/29 15:15
 */
@Data
public class SaveMallUserAddressParam {

    @ApiModelProperty("收件人名称")
    private String userName;

    @ApiModelProperty("收件人联系方式")
    private String userPhone;

    @ApiModelProperty("是否默认地址 0-不是 1-是")
    private Byte defaultFlag;

    @ApiModelProperty("省")
    private String provinceName;

    @ApiModelProperty("市")
    private String cityName;

    @ApiModelProperty("区/县")
    private String regionName;

    @ApiModelProperty("详细地址")
    private String detailAddress;
}
