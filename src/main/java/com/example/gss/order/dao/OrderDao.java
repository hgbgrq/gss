package com.example.gss.order.dao;

import com.example.gss.order.dto.OrderProductModel;
import com.example.gss.order.dto.req.OrderReq;
import com.example.gss.order.dto.OrderModel;
import com.example.gss.order.dto.res.OrderResDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    String test();

    List<OrderModel> selectOrders(OrderReq orderReq);

    Integer selectOrdersCount(OrderReq orderReq);

    OrderResDetail selectDetailOrder(String ordId);

    void insertOrder(OrderModel orderModel);

    void insertOrderProduct(OrderProductModel orderProductModel);

}
