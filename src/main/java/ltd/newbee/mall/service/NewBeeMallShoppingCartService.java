package ltd.newbee.mall.service;

import ltd.newbee.mall.api.mall.param.SaveCartItemParam;
import ltd.newbee.mall.api.mall.param.UpdateCartItemParam;
import ltd.newbee.mall.api.mall.vo.NewBeeMallShoppingCartItemVO;
import ltd.newbee.mall.entity.NewBeeMallShoppingCartItem;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;

/**
 * 商城购物车服务层接口
 *
 * 该接口定义了商城购物车相关的服务方法，包括保存商品至购物车、
 * 修改购物车中的属性、获取购物项详情、删除购物车中的商品、获取我的购物车中的列表数据、
 * 根据userId和cartItemIds获取对应的购物项记录、我的购物车(分页数据)等功能。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/29 16:21
 */
public interface NewBeeMallShoppingCartService {

    /**
     * 保存商品至购物车中
     *
     * @param saveCartItemParam 保存购物车商品信息的参数对象
     * @param userId 用户ID
     * @return 保存结果，成功返回ServiceResultEnum.SUCCESS.getResult()，否则返回相应错误码
     */
    String saveNewBeeMallCartItem(SaveCartItemParam saveCartItemParam, Long userId);

    /**
     * 修改购物车中的属性
     *
     * @param updateCartItemParam 更新购物车商品信息的参数对象
     * @param userId 用户ID
     * @return 修改结果，成功返回ServiceResultEnum.SUCCESS.getResult()，否则返回相应错误码
     */
    String updateNewBeeMallCartItem(UpdateCartItemParam updateCartItemParam, Long userId);

    /**
     * 获取购物项详情
     *
     * @param newBeeMallShoppingCartItemId 购物车项ID
     * @return 购物车项详情对象
     */
    NewBeeMallShoppingCartItem getNewBeeMallCartItemById(Long newBeeMallShoppingCartItemId);

    /**
     * 删除购物车中的商品
     *
     * @param shoppingCartItemId 购物车项ID
     * @param userId 用户ID
     * @return 删除结果，成功返回true，否则返回false
     */
    Boolean deleteById(Long shoppingCartItemId, Long userId);

    /**
     * 获取我的购物车中的列表数据
     *
     * @param newBeeMallUserId 用户ID
     * @return 我的购物车中的列表数据
     */
    List<NewBeeMallShoppingCartItemVO> getMyShoppingCartItems(Long newBeeMallUserId);

    /**
     * 获取我的购物车中的列表数据
     *
     * @param newBeeMallUserId 用户ID
     * @return 我的购物车中的列表数据
     */
    List<NewBeeMallShoppingCartItemVO> getCartItemsForSettle(List<Long> cartItemIds, Long newBeeMallUserId);

    /**
     * 我的购物车(分页数据)
     *
     * @param pageUtil 分页查询参数对象
     * @return 我的购物车的分页结果数据
     */
    PageResult getMyShoppingCartItems(PageQueryUtil pageUtil);
}
