package com.example.gss.order.svc;

import com.example.gss.order.dao.OrderDao;
import com.example.gss.order.dto.req.OrderReqDto;
import com.example.gss.order.dto.OrderModel;
import com.example.gss.order.dto.res.OrderResDetailDto;
import com.example.gss.order.dto.res.OrderResListDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderSvc {

    @Autowired
    private OrderDao orderDao;

    public String test(){
        return orderDao.test();
    }

    public OrderResListDto selectOrderList(OrderReqDto orderReqDto){
        OrderResListDto result = new OrderResListDto();
        List<OrderModel> list = orderDao.selectOrders(orderReqDto);
        Integer totalCount = orderDao.selectOrdersCount(orderReqDto);
        result.setList(list);
        result.setTotalCount(totalCount);
        return result;
    }

    public OrderResDetailDto selectOrderDetail(String orderId){
        OrderResDetailDto result = orderDao.selectDetailOrder(orderId);
        return result;
    }


}
