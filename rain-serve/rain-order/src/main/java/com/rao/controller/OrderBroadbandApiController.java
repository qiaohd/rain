package com.rao.controller;

import com.rao.annotation.BeanValid;
import com.rao.annotation.SimpleParam;
import com.rao.annotation.SimpleValid;
import com.rao.pojo.bo.CurrentUserInfo;
import com.rao.pojo.dto.CreateBroadbandOrderDTO;
import com.rao.pojo.vo.BroadbandOrderDetailVO;
import com.rao.pojo.vo.CreateOrderVO;
import com.rao.pojo.vo.DisposeOrderDetailVO;
import com.rao.pojo.vo.ListBroadbandOrderVO;
import com.rao.service.OrderBroadbandService;
import com.rao.util.result.ResultMessage;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 订单 controller-C端接口
 *
 * @author raojing
 * @date 2020/4/12 10:29
 */
@RestController
@RequestMapping("/api/order/broadband")
public class OrderBroadbandApiController {

    @Resource
    private OrderBroadbandService orderBroadbandService;

    /**
     * 创建宽带订单
     *
     * @param createBroadbandOrderDTO
     * @param currentUserInfo
     * @return
     */
    @PostMapping("/create_order")
    public ResultMessage<CreateOrderVO> createOrder(@RequestBody @BeanValid CreateBroadbandOrderDTO createBroadbandOrderDTO,
                                                    CurrentUserInfo currentUserInfo) {
        CreateOrderVO createOrderVO = orderBroadbandService.createOrder(createBroadbandOrderDTO, currentUserInfo);
        return ResultMessage.success(createOrderVO).message("下单成功");
    }

    /**
     * 订单列表
     *
     * @param status
     * @param currentUserInfo
     * @return
     */
    @PostMapping("/order_list")
    public ResultMessage<List<ListBroadbandOrderVO>> orderList(@SimpleParam @SimpleValid @Range(min = 1, max = 3, message = "订单状态非法") Integer status,
                                                               CurrentUserInfo currentUserInfo) {
        List<ListBroadbandOrderVO> orderVOList = orderBroadbandService.orderList(status, currentUserInfo.getId());
        return ResultMessage.success(orderVOList).message("获取订单列表成功");
    }

    /**
     * 订单详情
     *
     * @param orderId
     * @param currentUserInfo
     * @return
     */
    @GetMapping("/{orderId}")
    public ResultMessage<BroadbandOrderDetailVO> orderDetail(@PathVariable("orderId") Long orderId,
                                                             CurrentUserInfo currentUserInfo) {
        BroadbandOrderDetailVO orderDetailVO = orderBroadbandService.orderDetail(orderId, currentUserInfo.getId());
        return ResultMessage.success(orderDetailVO).message("获取订单详情成功");
    }

    /**
     * 工作人员通过小程序码或订单code进入订单管理页
     *
     * @param orderId
     * @param currentUserInfo
     * @return
     */
    @PostMapping("/dispose_order_detail")
    public ResultMessage<DisposeOrderDetailVO> disposeOrderDetail(@SimpleParam @SimpleValid @NotNull(message = "订单ID不能为空") Long orderId,
                                                                  CurrentUserInfo currentUserInfo) {
        DisposeOrderDetailVO disposeOrderDetail = orderBroadbandService.disposeOrderDetail(orderId, currentUserInfo);
        return ResultMessage.success(disposeOrderDetail).message("获取订单详情成功");
    }

    /**
     * 工作人员处理订单
     *
     * @param orderId
     * @param operation
     * @param currentUserInfo
     * @return
     */
    @PostMapping("/dispose_order")
    public ResultMessage disposeOrder(@SimpleParam @SimpleValid @NotNull(message = "订单ID不能为空") Long orderId,
                                      @SimpleParam @SimpleValid @NotNull(message = "订单类型不能为空") @Range(min = 1, max = 3, message = "订单操作非法") Integer operation,
                                      CurrentUserInfo currentUserInfo) {
        orderBroadbandService.disposeOrder(orderId, operation, currentUserInfo);
        return ResultMessage.success();
    }

}
