package ltd.newbee.mall.api.mall;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ltd.newbee.mall.api.mall.param.MallUserLoginParam;
import ltd.newbee.mall.api.mall.param.MallUserRegisterParam;
import ltd.newbee.mall.api.mall.param.MallUserUpdateParam;
import ltd.newbee.mall.api.mall.vo.NewBeeMallUserVO;
import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.config.annotation.TokenToMallUser;
import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.service.NewBeeMallUserService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.NumberUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author AnthonyCJ
 * @version 1.0
 * @description 新蜂商城个人用户操作API接口控制器
 * @date 2023/07/29 23:12
 */
@RestController
@Api(value = "v1", tags = "2.新蜂商城用户操作相关接口")
@RequestMapping("/api/v1")
public class NewBeeMallPersonalAPI {

    @Resource
    private NewBeeMallUserService newBeeMallUserService;

    private static final Logger logger = LoggerFactory.getLogger(NewBeeMallPersonalAPI.class);

    /**
     * 登录接口
     *
     * @param mallUserLoginParam 登录参数对象
     * @return 登录成功返回token
     */
    @PostMapping("/user/login")
    @ApiOperation(value = "登录接口", notes = "返回token")
    public Result<String> login(@RequestBody @Valid MallUserLoginParam mallUserLoginParam) {
        if (!NumberUtil.isPhone(mallUserLoginParam.getLoginName())){
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());
        }
        String loginResult = newBeeMallUserService.login(mallUserLoginParam.getLoginName(), mallUserLoginParam.getPasswordMd5());

        logger.info("login api,loginName={},loginResult={}", mallUserLoginParam.getLoginName(), loginResult);

        // 登录成功
        if (StringUtils.hasText(loginResult) && loginResult.length() == Constants.TOKEN_LENGTH) {
            Result result = ResultGenerator.genSuccessResult();
            result.setData(loginResult);
            return result;
        }
        // 登录失败
        return ResultGenerator.genFailResult(loginResult);
    }

    /**
     * 登出接口
     *
     * @param loginMallUser 登录用户对象
     * @return 登出成功返回成功信息
     */
    @PostMapping("/user/logout")
    @ApiOperation(value = "登出接口", notes = "清除token")
    public Result<String> logout(@TokenToMallUser MallUser loginMallUser) {
        Boolean logoutResult = newBeeMallUserService.logout(loginMallUser.getUserId());

        logger.info("logout api,loginMallUser={}", loginMallUser.getUserId());

        // 登出成功
        if (logoutResult) {
            return ResultGenerator.genSuccessResult();
        }
        // 登出失败
        return ResultGenerator.genFailResult("logout error");
    }

    /**
     * 用户注册接口
     *
     * @param mallUserRegisterParam 用户注册参数对象
     * @return 注册成功返回成功信息
     */
    @PostMapping("/user/register")
    @ApiOperation(value = "用户注册", notes = "")
    public Result register(@RequestBody @Valid MallUserRegisterParam mallUserRegisterParam) {
        if (!NumberUtil.isPhone(mallUserRegisterParam.getLoginName())){
            return ResultGenerator.genFailResult(ServiceResultEnum.LOGIN_NAME_IS_NOT_PHONE.getResult());
        }
        String registerResult = newBeeMallUserService.register(mallUserRegisterParam.getLoginName(), mallUserRegisterParam.getPassword());

        logger.info("register api,loginName={},loginResult={}", mallUserRegisterParam.getLoginName(), registerResult);

        // 注册成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            return ResultGenerator.genSuccessResult();
        }
        // 注册失败
        return ResultGenerator.genFailResult(registerResult);
    }

    /**
     * 修改用户信息接口
     *
     * @param mallUserUpdateParam 用户信息参数对象
     * @param loginMallUser       登录用户对象
     * @return 修改成功返回成功信息，修改失败返回失败信息
     */
    @PutMapping("/user/info")
    @ApiOperation(value = "修改用户信息", notes = "")
    public Result updateInfo(@RequestBody @ApiParam("用户信息") MallUserUpdateParam mallUserUpdateParam, @TokenToMallUser MallUser loginMallUser) {
        Boolean flag = newBeeMallUserService.updateUserInfo(mallUserUpdateParam, loginMallUser.getUserId());
        if (flag) {
            // 返回成功
            Result result = ResultGenerator.genSuccessResult();
            return result;
        } else {
            // 返回失败
            Result result = ResultGenerator.genFailResult("修改失败");
            return result;
        }
    }

    /**
     * 获取用户信息接口
     *
     * @param loginMallUser 登录用户对象
     * @return 返回登录用户信息
     */
    @GetMapping("/user/info")
    @ApiOperation(value = "获取用户信息", notes = "")
    public Result<NewBeeMallUserVO> getUserDetail(@TokenToMallUser MallUser loginMallUser) {
        // 已登录则直接返回
        NewBeeMallUserVO mallUserVO = new NewBeeMallUserVO();
        BeanUtil.copyProperties(loginMallUser, mallUserVO);
        return ResultGenerator.genSuccessResult(mallUserVO);
    }
}
