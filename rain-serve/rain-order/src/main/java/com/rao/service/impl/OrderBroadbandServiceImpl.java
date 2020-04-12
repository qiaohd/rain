package com.rao.service.impl;

import com.rao.dao.RainOrderBroadbandDao;
import com.rao.dao.RainOrderBroadbandSubDao;
import com.rao.pojo.bo.CurrentUserInfo;
import com.rao.pojo.dto.CreateBroadbandOrderDTO;
import com.rao.pojo.vo.BroadbandOrderDetailVO;
import com.rao.pojo.vo.CreateOrderVO;
import com.rao.pojo.vo.DisposeOrderDetailVO;
import com.rao.pojo.vo.ListBroadbandOrderVO;
import com.rao.service.OrderBroadbandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 宽带订单-service
 *
 * @author raojing
 * @date 2020/4/12 10:31
 */
@Slf4j
@Service
public class OrderBroadbandServiceImpl implements OrderBroadbandService {

    @Resource
    private RainOrderBroadbandDao rainOrderBroadbandDao;
    @Resource
    private RainOrderBroadbandSubDao rainOrderBroadbandSubDao;

    @Override
    public CreateOrderVO createOrder(CreateBroadbandOrderDTO createBroadbandOrderDTO, CurrentUserInfo currentUserInfo) {


        return null;
    }

    @Override
    public List<ListBroadbandOrderVO> orderList(Integer status, Long id) {
        return null;
    }

    @Override
    public BroadbandOrderDetailVO orderDetail(Long orderId, Long id) {
        return null;
    }

    @Override
    public DisposeOrderDetailVO disposeOrderDetail(Long orderId, CurrentUserInfo currentUserInfo) {
        return null;
    }

    @Override
    public void disposeOrder(Long orderId, Integer operation, CurrentUserInfo currentUserInfo) {

    }
}
