package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.api.mall.vo.NewBeeMallUserAddressVO;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.MallUserAddressMapper;
import ltd.newbee.mall.entity.MallUserAddress;
import ltd.newbee.mall.service.NewBeeMallUserAddressService;
import ltd.newbee.mall.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户地址管理服务实现类
 *
 * 该类实现了NewBeeMallUserAddressService接口，提供了对用户地址的增删改查等功能。
 *
 * @author AnthonyCJ
 * @Autowired 用于自动装配MallUserAddressMapper，实现对用户地址表的操作。
 * @Service 用于标识该类是一个服务层组件，将其作为Spring容器中的Bean进行管理。
 */
@Service
public class NewBeeMallUserAddressServiceImpl implements NewBeeMallUserAddressService {

    @Autowired
    private MallUserAddressMapper userAddressMapper;

    /**
     * 获取指定用户的地址列表
     *
     * @param userId 用户ID
     * @return 用户地址列表的VO对象集合
     */
    @Override
    public List<NewBeeMallUserAddressVO> getMyAddresses(Long userId) {
        List<MallUserAddress> myAddressList = userAddressMapper.findMyAddressList(userId);
        List<NewBeeMallUserAddressVO> newBeeMallUserAddressVOS = BeanUtil.copyList(myAddressList, NewBeeMallUserAddressVO.class);
        return newBeeMallUserAddressVOS;
    }

    /**
     * 保存用户地址
     *
     * @param mallUserAddress 用户地址对象
     * @return 保存成功返回true，否则返回false。
     */
    @Override
    @Transactional
    public Boolean saveUserAddress(MallUserAddress mallUserAddress) {
        Date now = new Date();
        if (mallUserAddress.getDefaultFlag().intValue() == 1) {
            //添加默认地址，需要将原有的默认地址修改掉
            MallUserAddress defaultAddress = userAddressMapper.getMyDefaultAddress(mallUserAddress.getUserId());
            if (defaultAddress != null) {
                defaultAddress.setDefaultFlag((byte) 0);
                defaultAddress.setUpdateTime(now);
                int updateResult = userAddressMapper.updateByPrimaryKeySelective(defaultAddress);
                if (updateResult < 1) {
                    //未更新成功
                    NewBeeMallException.fail(ServiceResultEnum.DB_ERROR.getResult());
                }
            }
        }
        return userAddressMapper.insertSelective(mallUserAddress) > 0;
    }

    /**
     * 更新用户地址
     *
     * @param mallUserAddress 用户地址对象
     * @return 更新成功返回true，否则返回false。
     */
    @Override
    public Boolean updateMallUserAddress(MallUserAddress mallUserAddress) {
        MallUserAddress tempAddress = getMallUserAddressById(mallUserAddress.getAddressId());
        Date now = new Date();
        if (mallUserAddress.getDefaultFlag().intValue() == 1) {
            //修改为默认地址，需要将原有的默认地址修改掉
            MallUserAddress defaultAddress = userAddressMapper.getMyDefaultAddress(mallUserAddress.getUserId());
            if (defaultAddress != null && !defaultAddress.getAddressId().equals(tempAddress)) {
                //存在默认地址且默认地址并不是当前修改的地址
                defaultAddress.setDefaultFlag((byte) 0);
                defaultAddress.setUpdateTime(now);
                int updateResult = userAddressMapper.updateByPrimaryKeySelective(defaultAddress);
                if (updateResult < 1) {
                    //未更新成功
                    NewBeeMallException.fail(ServiceResultEnum.DB_ERROR.getResult());
                }
            }
        }
        mallUserAddress.setUpdateTime(now);
        return userAddressMapper.updateByPrimaryKeySelective(mallUserAddress) > 0;
    }

    /**
     * 根据地址ID获取用户地址信息
     *
     * @param addressId 地址ID
     * @return 用户地址对象
     * @throws NewBeeMallException 当地址不存在时抛出异常
     */
    @Override
    public MallUserAddress getMallUserAddressById(Long addressId) {
        MallUserAddress mallUserAddress = userAddressMapper.selectByPrimaryKey(addressId);
        if (mallUserAddress == null) {
            NewBeeMallException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return mallUserAddress;
    }

    /**
     * 获取指定用户的默认地址
     *
     * @param userId 用户ID
     * @return 用户默认地址对象
     */
    @Override
    public MallUserAddress getMyDefaultAddressByUserId(Long userId) {
        return userAddressMapper.getMyDefaultAddress(userId);
    }

    /**
     * 根据地址ID删除用户地址
     *
     * @param addressId 地址ID
     * @return 删除成功返回true，否则返回false。
     */
    @Override
    public Boolean deleteById(Long addressId) {
        return userAddressMapper.deleteByPrimaryKey(addressId) > 0;
    }
}
