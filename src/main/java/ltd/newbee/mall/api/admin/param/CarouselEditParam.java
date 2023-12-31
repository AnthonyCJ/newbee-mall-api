package ltd.newbee.mall.api.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 轮播图编辑参数类
 * 用于接收编辑轮播图时的参数信息
 */
@Data
public class CarouselEditParam {

    /**
     * 待修改轮播图id
     */
    @ApiModelProperty("待修改轮播图id")
    @NotNull(message = "轮播图id不能为空")
    @Min(1)
    private Integer carouselId;

    /**
     * 轮播图URL地址
     */
    @ApiModelProperty("轮播图URL地址")
    @NotEmpty(message = "轮播图URL不能为空")
    private String carouselUrl;

    /**
     * 轮播图跳转地址
     */
    @ApiModelProperty("轮播图跳转地址")
    @NotEmpty(message = "轮播图跳转地址不能为空")
    private String redirectUrl;

    /**
     * 排序值
     */
    @ApiModelProperty("排序值")
    @Min(value = 1, message = "carouselRank最低为1")
    @Max(value = 200, message = "carouselRank最高为200")
    @NotNull(message = "carouselRank不能为空")
    private Integer carouselRank;
}
