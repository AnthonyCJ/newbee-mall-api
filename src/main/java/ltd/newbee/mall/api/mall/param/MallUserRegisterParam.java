package ltd.newbee.mall.api.mall.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 用户注册param
 * @date 2023/07/29 15:13
 */
@Data
public class MallUserRegisterParam implements Serializable {

    @ApiModelProperty("登录名")
    @NotEmpty(message = "登录名不能为空")
    private String loginName;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
