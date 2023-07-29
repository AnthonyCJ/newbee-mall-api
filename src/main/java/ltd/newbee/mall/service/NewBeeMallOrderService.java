package ltd.newbee.mall.service;

import ltd.newbee.mall.api.mall.vo.NewBeeMallOrderDetailVO;
import ltd.newbee.mall.api.mall.vo.NewBeeMallOrderItemVO;
import ltd.newbee.mall.api.mall.vo.NewBeeMallShoppingCartItemVO;
import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.entity.MallUserAddress;
import ltd.newbee.mall.entity.NewBeeMallOrder;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

import java.util.List;

/**
 * 商城订单service层接口
 *
 * 该接口定义了一系列订单相关的功能，包括获取订单详情、我的订单列表、取消订单、确认收货等操作。
 * 其中部分方法用于后台管理系统，用于实现订单管理功能，包括订单信息修改、配货、出库、关闭订单等功能。
 *
 * @author AnthonyCJ
 * @version 1.0
 * @date 2023/07/29 16:27
 */
public interface NewBeeMallOrderService {
    /**
     * 根据订单ID获取订单详情
     *
     * @param orderId 订单ID
     * @return 订单详情对象
     */
    NewBeeMallOrderDetailVO getOrderDetailByOrderId(Long orderId);

    /**
     * 根据订单号和用户ID获取订单详情
     *
     * @param orderNo 订单号
     * @param userId 用户ID
     * @return 订单详情对象
     */
    NewBeeMallOrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId);

    /**
     * 获取我的订单列表
     *
     * @param pageUtil 分页查询工具类
     * @return 分页结果对象
     */
    PageResult getMyOrders(PageQueryUtil pageUtil);

    /**
     * 手动取消订单
     *
     * @param orderNo 订单号
     * @param userId 用户ID
     * @return 取消订单结果，返回成功或失败信息
     */
    String cancelOrder(String orderNo, Long userId);

    /**
     * 确认订单
     *
     * @param orderNo 订单号
     * @param userId 用户ID
     * @return 确认订单结果，返回成功或失败信息
     */
    String finishOrder(String orderNo, Long userId);

    /**
     * 订单支付成功回调
     *
     * @param orderNo 订单号
     * @param payType 支付类型（如支付宝、微信等）
     * @return 支付成功结果，返回成功或失败信息
     */
    String paySuccess(String orderNo, int payType);

    /**
     * 创建订单并保存到数据库
     *
     * @param loginMallUser 下单用户信息
     * @param address 收货地址信息
     * @param itemsForSave 购物车项列表
     * @return 保存订单结果，返回成功或失败信息
     */
    String saveOrder(MallUser loginMallUser, MallUserAddress address, List<NewBeeMallShoppingCartItemVO> itemsForSave);

    /**
     * 后台分页查询订单列表
     *
     * @param pageUtil 分页查询工具类
     * @return 分页结果对象
     */
    PageResult getNewBeeMallOrdersPage(PageQueryUtil pageUtil);

    /**
     * 修改订单信息
     *
     * @param newBeeMallOrder 订单对象
     * @return 修改订单结果，返回成功或失败信息
     */
    String updateOrderInfo(NewBeeMallOrder newBeeMallOrder);

    /**
     * 配货处理
     *
     * @param ids 订单ID数组
     * @return 配货结果，返回成功或失败信息
     */
    String checkDone(Long[] ids);

    /**
     * 出库处理
     *
     * @param ids 订单ID数组
     * @return 出库结果，返回成功或失败信息
     */
    String checkOut(Long[] ids);

    /**
     * 关闭订单
     *
     * @param ids 订单ID数组
     * @return 关闭订单结果，返回成功或失败信息
     */
    String closeOrder(Long[] ids);

    /**
     * 根据订单ID获取订单项列表
     *
     * @param orderId 订单ID
     * @return 订单项列表
     */
    List<NewBeeMallOrderItemVO> getOrderItems(Long orderId);
}
