package ltd.newbee.mall.api.mall.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 用户修改param
 * @date 2023/07/29 14:57
 */
@Data
public class MallUserUpdateParam implements Serializable {

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户密码(需要MD5加密)")
    private String passwordMd5;

    @ApiModelProperty("个性签名")
    private String introduceSign;

}
