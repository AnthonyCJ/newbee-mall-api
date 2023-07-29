package ltd.newbee.mall.service;

import ltd.newbee.mall.api.mall.vo.NewBeeMallUserAddressVO;
import ltd.newbee.mall.entity.MallUserAddress;

import java.util.List;

/**
 * 商城用户地址服务层接口
 *
 * 该接口定义了商城用户地址相关的服务方法，包括获取我的收货地址、保存收货地址、修改收货地址、获取收货地址详情、获取我的默认收货地址、删除收货地址等功能。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/29 15:04
 */
public interface NewBeeMallUserAddressService {

    /**
     * 获取我的收货地址
     *
     * @param userId 用户ID
     * @return 我的收货地址列表
     */
    List<NewBeeMallUserAddressVO> getMyAddresses(Long userId);

    /**
     * 保存收货地址
     *
     * @param mallUserAddress 收货地址信息对象
     * @return 保存成功返回true，否则返回false
     */
    Boolean saveUserAddress(MallUserAddress mallUserAddress);

    /**
     * 修改收货地址
     *
     * @param mallUserAddress 收货地址信息对象
     * @return 修改成功返回true，否则返回false
     */
    Boolean updateMallUserAddress(MallUserAddress mallUserAddress);

    /**
     * 获取收货地址详情
     *
     * @param addressId 地址ID
     * @return 收货地址详情对象
     */
    MallUserAddress getMallUserAddressById(Long addressId);

    /**
     * 获取我的默认收货地址
     *
     * @param userId 用户ID
     * @return 我的默认收货地址对象
     */
    MallUserAddress getMyDefaultAddressByUserId(Long userId);

    /**
     * 删除收货地址
     *
     * @param addressId 地址ID
     * @return 删除成功返回true，否则返回false
     */
    Boolean deleteById(Long addressId);
}
