package ltd.newbee.mall.api.admin.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品添加参数类
 * 用于接收商品添加时的参数信息
 */
@Data
public class GoodsAddParam {

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @NotEmpty(message = "商品名称不能为空")
    @Length(max = 128,message = "商品名称内容过长")
    private String goodsName;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品简介")
    @NotEmpty(message = "商品简介不能为空")
    @Length(max = 200,message = "商品简介内容过长")
    private String goodsIntro;

    /**
     * 分类id
     */
    @ApiModelProperty("分类id")
    @NotNull(message = "分类id不能为空")
    @Min(value = 1, message = "分类id最低为1")
    private Long goodsCategoryId;

    /**
     * 商品主图
     */
    @ApiModelProperty("商品主图")
    @NotEmpty(message = "商品主图不能为空")
    private String goodsCoverImg;

    /**
     * 商品原价
     */
    @ApiModelProperty("originalPrice")
    @NotNull(message = "originalPrice不能为空")
    @Min(value = 1, message = "originalPrice最低为1")
    @Max(value = 1000000, message = "originalPrice最高为1000000")
    private Integer originalPrice;

    /**
     * 商品售价
     */
    @ApiModelProperty("sellingPrice")
    @NotNull(message = "sellingPrice不能为空")
    @Min(value = 1, message = "sellingPrice最低为1")
    @Max(value = 1000000, message = "sellingPrice最高为1000000")
    private Integer sellingPrice;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    @NotNull(message = "库存不能为空")
    @Min(value = 1, message = "库存最低为1")
    @Max(value = 100000, message = "库存最高为100000")
    private Integer stockNum;

    /**
     * 商品标签
     */
    @ApiModelProperty("商品标签")
    @NotEmpty(message = "商品标签不能为空")
    @Length(max = 16,message = "商品标签内容过长")
    private String tag;

    /**
     * 商品销售状态
     */
    private Byte goodsSellStatus;

    /**
     * 商品详情
     */
    @ApiModelProperty("商品详情")
    @NotEmpty(message = "商品详情不能为空")
    private String goodsDetailContent;
}