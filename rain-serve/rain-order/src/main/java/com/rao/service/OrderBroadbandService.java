package com.rao.service;

import com.rao.pojo.bo.CurrentUserInfo;
import com.rao.pojo.dto.CreateBroadbandOrderDTO;
import com.rao.pojo.vo.BroadbandOrderDetailVO;
import com.rao.pojo.vo.CreateOrderVO;
import com.rao.pojo.vo.DisposeOrderDetailVO;
import com.rao.pojo.vo.ListBroadbandOrderVO;

import java.util.List;

/**
 * 宽带订单-service
 *
 * @author raojing
 * @date 2020/4/12 10:31
 */
public interface OrderBroadbandService {

    /**
     * 创建宽带订单
     * 1. 通过产品ID和套餐ID，调用产品服务获取产品信息
     * 2. 如果是校园订单，校验参数并调用基础支撑服务获取学校院系信息
     * 3. 生成订单ID，调用微信接口生成小程序码并上传至oss
     * 4. 创建订单
     * 5. 调微信支付下单接口生成支付参数返回前端
     *
     * @param createBroadbandOrderDTO
     * @param currentUserInfo
     * @return
     */
    CreateOrderVO createOrder(CreateBroadbandOrderDTO createBroadbandOrderDTO, CurrentUserInfo currentUserInfo);

    /**
     * 订单列表
     *
     * @param status
     * @param id
     * @return
     */
    List<ListBroadbandOrderVO> orderList(Integer status, Long id);

    /**
     * 订单详情
     *
     * @param orderId
     * @param id
     * @return
     */
    BroadbandOrderDetailVO orderDetail(Long orderId, Long id);

    /**
     * 工作人员通过小程序码或订单code进入订单管理页
     *
     * @param orderId
     * @param currentUserInfo
     * @return
     */
    DisposeOrderDetailVO disposeOrderDetail(Long orderId, CurrentUserInfo currentUserInfo);

    /**
     * 工作人员处理订单
     *
     * @param orderId
     * @param operation
     * @param currentUserInfo
     */
    void disposeOrder(Long orderId, Integer operation, CurrentUserInfo currentUserInfo);
}
