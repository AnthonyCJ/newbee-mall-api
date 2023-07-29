package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.MallUserAddress;

import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 商城用户地址dao层接口
 * @date 2023/07/28 10:27
 */
public interface MallUserAddressMapper {
    int deleteByPrimaryKey(Long addressId);

    int insert(MallUserAddress record);

    int insertSelective(MallUserAddress record);

    MallUserAddress selectByPrimaryKey(Long addressId);

    MallUserAddress getMyDefaultAddress(Long userId);

    List<MallUserAddress> findMyAddressList(Long userId);

    int updateByPrimaryKeySelective(MallUserAddress record);

    int updateByPrimaryKey(MallUserAddress record);
}
