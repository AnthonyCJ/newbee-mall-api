package ltd.newbee.mall.service;

import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;
/**
 * 商品信息服务层接口
 *
 * @author GnayYzal
 * @version 1.0
 * @date 2023/07/29 16:28
 */

public interface NewBeeMallGoodsService {

    /**
     * 后台分页
     *
     * @param pageUtil 分页查询条件
     * @return 分页查询结果
     */
    PageResult getNewBeeMallGoodsPage(PageQueryUtil pageUtil);

    /**
     * 添加商品
     *
     * @param goods 添加的商品信息
     * @return 操作结果，成功success
     */
    String saveNewBeeMallGoods(NewBeeMallGoods goods);

    /**
     * 批量新增商品数据
     *
     * @param newBeeMallGoodsList 待添加的商品信息列表。
     * 该方法没有返回值，表示执行保存操作但不返回具体结果。
     */
    void batchSaveNewBeeMallGoods(List<NewBeeMallGoods> newBeeMallGoodsList);

    /**
     * 修改商品信息
     *
     * @param goods 修改的商品信息
     * @return 操作结果，成功success
     */
    String updateNewBeeMallGoods(NewBeeMallGoods goods);

    /**
     * 批量修改销售状态(上架下架)
     *
     * @param ids 待更新销售状态的商品ID列表
     * @param sellStatus 要更新的销售状态
     * @return 批量更新销售状态的执行结果
     */
    Boolean batchUpdateSellStatus(Long[] ids, int sellStatus);

    /**
     * 获取商品详情
     *
     * @param id
     * @return 对应的商品信息，如果商品不存在，会抛出异常
     */
    NewBeeMallGoods getNewBeeMallGoodsById(Long id);

    /**
     * 商品搜索
     *
     * @param pageUtil 分页查询条件
     * @return 搜索结果的封装类对象，包括搜索到的商品列表、商品总数、每页显示的商品数量、当前页码
     */
    PageResult searchNewBeeMallGoods(PageQueryUtil pageUtil);
}
