package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 商品分类实体类，用于存储商品分类相关信息。
 *
 * 该实体类使用了Lombok的@Data注解，将自动生成getter、setter方法。
 *
 * 商品分类实体类包含了商品分类的各个属性，包括分类ID、分类级别、父级分类ID、
 * 分类名称、分类排序等信息，同时还包含了创建时间、创建者、更新时间和更新者等信息。
 *
 * 注：该实体类使用了com.fasterxml.jackson.annotation.JsonFormat注解，
 * 用于在JSON序列化时对日期属性进行格式化，时区设为GMT+8，格式为"yyyy-MM-dd HH:mm:ss"。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/27 20:37
 */
@Data
public class GoodsCategory {
    // 分类ID
    private Long categoryId;

    // 分类级别（1：一级分类，2：二级分类，3：三级分类）
    private Byte categoryLevel;

    // 父级分类ID
    private Long parentId;

    // 分类名称
    private String categoryName;

    // 分类排序
    private Integer categoryRank;

    // 是否已删除（0：未删除，1：已删除）
    private Byte isDeleted;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    // 创建者ID
    private Integer createUser;

    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    // 更新者ID
    private Integer updateUser;
}
