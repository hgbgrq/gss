package com.example.gss.order.dao;

import com.example.gss.order.dto.req.OrderReqDto;
import com.example.gss.order.dto.OrderModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    String test();

    List<OrderModel> selectOrders(OrderReqDto orderReqDto);

}
