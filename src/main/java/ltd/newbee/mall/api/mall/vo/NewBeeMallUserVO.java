package ltd.newbee.mall.api.mall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 商城用户VO
 * @date 2023/07/29 15:29
 */
@Data
public class NewBeeMallUserVO implements Serializable {

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户登录名")
    private String loginName;

    @ApiModelProperty("个性签名")
    private String introduceSign;
}
