package ltd.newbee.mall.entity;

import lombok.Data;

/**
 * 库存修改所需实体类，用于存储库存修改操作所需的数据。
 *
 * 该实体类使用了Lombok的@Data注解，自动生成了getter、setter方法等。
 *
 * 库存修改所需实体类包含了库存修改操作所需的数据，包括商品ID和商品数量等信息。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 22:46
 */
@Data
public class StockNumDTO {
    // 商品ID
    private Long goodsId;

    // 商品数量
    private Integer goodsCount;
}
