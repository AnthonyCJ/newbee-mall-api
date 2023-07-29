package ltd.newbee.mall.api.mall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 首页轮播图VO
 * @date 2023/07/29 15:23
 */
@Data
public class NewBeeMallIndexCarouselVO implements Serializable {

    @ApiModelProperty("轮播图图片地址")
    private String carouselUrl;

    @ApiModelProperty("轮播图点击后的跳转路径")
    private String redirectUrl;
}
