package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.NewBeeMallShoppingCartItem;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 用户购物车商品项dao层接口
 * @date 2023/07/28 11:01
 */
public interface NewBeeMallShoppingCartItemMapper {
    int deleteByPrimaryKey(Long cartItemId);

    int insert(NewBeeMallShoppingCartItem record);

    int insertSelective(NewBeeMallShoppingCartItem record);

    NewBeeMallShoppingCartItem selectByPrimaryKey(Long cartItemId);

    NewBeeMallShoppingCartItem selectByUserIdAndGoodsId(@Param("newBeeMallUserId") Long newBeeMallUserId, @Param("goodsId") Long goodsId);

    List<NewBeeMallShoppingCartItem> selectByUserId(@Param("newBeeMallUserId") Long newBeeMallUserId, @Param("number") int number);

    List<NewBeeMallShoppingCartItem> selectByUserIdAndCartItemIds(@Param("newBeeMallUserId") Long newBeeMallUserId, @Param("cartItemIds") List<Long> cartItemIds);

    int selectCountByUserId(Long newBeeMallUserId);

    int updateByPrimaryKeySelective(NewBeeMallShoppingCartItem record);

    int updateByPrimaryKey(NewBeeMallShoppingCartItem record);

    int deleteBatch(List<Long> ids);

    List<NewBeeMallShoppingCartItem> findMyNewBeeMallCartItems(PageQueryUtil pageUtil);

    int getTotalMyNewBeeMallCartItems(PageQueryUtil pageUtil);
}
