package com.example.gss.order.ctrl;

import com.example.gss.order.svc.OrderSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderCtrl {

    @Autowired
    private OrderSvc orderSvc;
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>(orderSvc.test(),HttpStatus.OK);
    }
}