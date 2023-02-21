package com.example.gss.order.ctrl;

import com.example.gss.order.dto.req.OrderEnrollReq;
import com.example.gss.order.dto.req.OrderReq;
import com.example.gss.order.dto.res.OrderResDetail;
import com.example.gss.order.dto.res.OrderResList;
import com.example.gss.order.svc.OrderSvc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Tag(name = "발주")
public class OrderCtrl {

    @Autowired
    private OrderSvc orderSvc;
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>(orderSvc.test(),HttpStatus.OK);
    }

    @Operation(summary = "주문 조회")
    @GetMapping
    public ResponseEntity<OrderResList> getOrderList(OrderReq orderReq){
        OrderResList result = orderSvc.selectOrderList(orderReq);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{ordId}")
    public ResponseEntity<OrderResDetail> getOrderDetail(@PathVariable String ordId){
        OrderResDetail result = orderSvc.selectOrderDetail(ordId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> enrollOrder(@RequestBody List<OrderEnrollReq> orderEnrollReqs){
        orderSvc.insertOrderInfo(orderEnrollReqs);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
