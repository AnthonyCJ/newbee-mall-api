package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.NewBeeMallOrderAddress;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 订单地址dao层接口
 * @date 2023/07/28 10:50
 */
public interface NewBeeMallOrderAddressMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(NewBeeMallOrderAddress record);

    int insertSelective(NewBeeMallOrderAddress record);

    NewBeeMallOrderAddress selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(NewBeeMallOrderAddress record);

    int updateByPrimaryKey(NewBeeMallOrderAddress record);
}
