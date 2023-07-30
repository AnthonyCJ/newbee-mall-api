package ltd.newbee.mall.service;

import ltd.newbee.mall.api.mall.vo.NewBeeMallIndexCategoryVO;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;

/**
 * 商城轮播图服务层接口
 *
 * @author GnayYzal
 * @version 1.0
 * @date 2023/07/29 16:20
 */

public interface NewBeeMallCategoryService {

    /**
     * 添加商品分类
     *
     * @param goodsCategory 要保存的商品分类数据对象
     * @return 操作结果，成功success
     */
    String saveCategory(GoodsCategory goodsCategory);

    /**
     * 更新商品分类
     *
     * @param goodsCategory 要更新的商品分类数据对象
     * @return 操作结果，成功success
     */
    String updateGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 查询对应分类id的商品分类数据
     *
     * @param id 分类id
     * @return 返回该分类数据对象
     */
    GoodsCategory getGoodsCategoryById(Long id);

    /**
     * 批量删除商品分类
     *
     * @param ids 需要批量删除的商品分类id
     * @return 删除操作的结果，成功为true
     */
    Boolean deleteBatch(Long[] ids);

    /**
     * 返回分类数据(首页调用)
     *
     * @return 商品分类数据VO对象集合
     */
    List<NewBeeMallIndexCategoryVO> getCategoriesForIndex();

    /**
     * 后台分页
     *
     * @param pageUtil 分页查询条件（每页数据数量和所在页码）
     * @return 查询结果的分页对象，该对象包含查询到的商品分类列表、总记录数、每页显示的记录数和当前页数。
     */
    PageResult getCategorisPage(PageQueryUtil pageUtil);

    /**
     * 根据parentId和level获取分类列表
     *
     * @param parentIds 父级分类 IDs
     * @param categoryLevel 分类等级
     * @return 查询到的商品分类数据列表
     */
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);
}
