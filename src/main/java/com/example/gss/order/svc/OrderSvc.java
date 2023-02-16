package com.example.gss.order.svc;

import com.example.gss.order.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSvc {

    @Autowired
    private OrderDao orderDao;

    public String test(){
        return orderDao.test();
    }


}
