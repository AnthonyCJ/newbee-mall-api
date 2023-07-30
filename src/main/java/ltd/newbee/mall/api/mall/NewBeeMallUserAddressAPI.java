package ltd.newbee.mall.api.mall;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ltd.newbee.mall.api.mall.param.SaveMallUserAddressParam;
import ltd.newbee.mall.api.mall.param.UpdateMallUserAddressParam;
import ltd.newbee.mall.api.mall.vo.NewBeeMallUserAddressVO;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.config.annotation.TokenToMallUser;
import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.entity.MallUserAddress;
import ltd.newbee.mall.service.NewBeeMallUserAddressService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 新蜂商城个人地址相关API接口控制器
 * @date 2023/07/30 10:13
 */
@RestController
@Api(value = "v1", tags = "6.新蜂商城个人地址相关接口")
@RequestMapping("/api/v1")
public class NewBeeMallUserAddressAPI {

    @Resource
    private NewBeeMallUserAddressService mallUserAddressService;

    /**
     * 我的收货地址列表接口
     *
     * @param loginMallUser 登录用户对象
     * @return 返回我的收货地址列表数据
     */
    @GetMapping("/address")
    @ApiOperation(value = "我的收货地址列表", notes = "")
    public Result<List<NewBeeMallUserAddressVO>> addressList(@TokenToMallUser MallUser loginMallUser) {
        return ResultGenerator.genSuccessResult(mallUserAddressService.getMyAddresses(loginMallUser.getUserId()));
    }

    /**
     * 添加地址接口
     *
     * @param saveMallUserAddressParam 添加地址参数对象
     * @param loginMallUser            登录用户对象
     * @return 添加成功返回成功信息，添加失败返回失败信息
     */
    @PostMapping("/address")
    @ApiOperation(value = "添加地址", notes = "")
    public Result<Boolean> saveUserAddress(@RequestBody SaveMallUserAddressParam saveMallUserAddressParam,
                                           @TokenToMallUser MallUser loginMallUser) {
        MallUserAddress userAddress = new MallUserAddress();
        BeanUtil.copyProperties(saveMallUserAddressParam, userAddress);
        userAddress.setUserId(loginMallUser.getUserId());
        Boolean saveResult = mallUserAddressService.saveUserAddress(userAddress);
        // 添加成功
        if (saveResult) {
            return ResultGenerator.genSuccessResult();
        }
        // 添加失败
        return ResultGenerator.genFailResult("添加失败");
    }

    /**
     * 修改地址接口
     *
     * @param updateMallUserAddressParam 修改地址参数对象
     * @param loginMallUser              登录用户对象
     * @return 修改成功返回成功信息，修改失败返回失败信息
     */
    @PutMapping("/address")
    @ApiOperation(value = "修改地址", notes = "")
    public Result<Boolean> updateMallUserAddress(@RequestBody UpdateMallUserAddressParam updateMallUserAddressParam,
                                                 @TokenToMallUser MallUser loginMallUser) {
        MallUserAddress mallUserAddressById = mallUserAddressService.getMallUserAddressById(updateMallUserAddressParam.getAddressId());
        if (!loginMallUser.getUserId().equals(mallUserAddressById.getUserId())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.REQUEST_FORBIDEN_ERROR.getResult());
        }
        MallUserAddress userAddress = new MallUserAddress();
        BeanUtil.copyProperties(updateMallUserAddressParam, userAddress);
        userAddress.setUserId(loginMallUser.getUserId());
        Boolean updateResult = mallUserAddressService.updateMallUserAddress(userAddress);
        // 修改成功
        if (updateResult) {
            return ResultGenerator.genSuccessResult();
        }
        // 修改失败
        return ResultGenerator.genFailResult("修改失败");
    }

    /**
     * 获取收货地址详情接口
     *
     * @param addressId     地址id
     * @param loginMallUser 登录用户对象
     * @return 返回收货地址详情数据
     */
    @GetMapping("/address/{addressId}")
    @ApiOperation(value = "获取收货地址详情", notes = "传参为地址id")
    public Result<NewBeeMallUserAddressVO> getMallUserAddress(@PathVariable("addressId") Long addressId,
                                                              @TokenToMallUser MallUser loginMallUser) {
        MallUserAddress mallUserAddressById = mallUserAddressService.getMallUserAddressById(addressId);
        NewBeeMallUserAddressVO newBeeMallUserAddressVO = new NewBeeMallUserAddressVO();
        BeanUtil.copyProperties(mallUserAddressById, newBeeMallUserAddressVO);
        if (!loginMallUser.getUserId().equals(mallUserAddressById.getUserId())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.REQUEST_FORBIDEN_ERROR.getResult());
        }
        return ResultGenerator.genSuccessResult(newBeeMallUserAddressVO);
    }

    /**
     * 获取默认收货地址接口
     *
     * @param loginMallUser 登录用户对象
     * @return 返回默认收货地址数据
     */
    @GetMapping("/address/default")
    @ApiOperation(value = "获取默认收货地址", notes = "无传参")
    public Result getDefaultMallUserAddress(@TokenToMallUser MallUser loginMallUser) {
        MallUserAddress mallUserAddressById = mallUserAddressService.getMyDefaultAddressByUserId(loginMallUser.getUserId());
        return ResultGenerator.genSuccessResult(mallUserAddressById);
    }

    /**
     * 删除收货地址接口
     *
     * @param addressId     地址id
     * @param loginMallUser 登录用户对象
     * @return 删除成功返回成功信息，删除失败返回失败信息
     */
    @DeleteMapping("/address/{addressId}")
    @ApiOperation(value = "删除收货地址", notes = "传参为地址id")
    public Result deleteAddress(@PathVariable("addressId") Long addressId,
                                @TokenToMallUser MallUser loginMallUser) {
        MallUserAddress mallUserAddressById = mallUserAddressService.getMallUserAddressById(addressId);
        if (!loginMallUser.getUserId().equals(mallUserAddressById.getUserId())) {
            return ResultGenerator.genFailResult(ServiceResultEnum.REQUEST_FORBIDEN_ERROR.getResult());
        }
        Boolean deleteResult = mallUserAddressService.deleteById(addressId);
        // 删除成功
        if (deleteResult) {
            return ResultGenerator.genSuccessResult();
        }
        // 删除失败
        return ResultGenerator.genFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
    }
}
