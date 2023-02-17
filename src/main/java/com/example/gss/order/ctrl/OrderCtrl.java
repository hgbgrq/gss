package com.example.gss.order.ctrl;

import com.example.gss.order.dto.req.OrderReqDto;
import com.example.gss.order.dto.res.OrderResDetailDto;
import com.example.gss.order.dto.res.OrderResListDto;
import com.example.gss.order.svc.OrderSvc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Tag(name = "07. 권한 컨트롤러")
public class OrderCtrl {

    @Autowired
    private OrderSvc orderSvc;
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>(orderSvc.test(),HttpStatus.OK);
    }

    @Operation(summary = "주문 조회")
    @GetMapping
    public ResponseEntity<OrderResListDto> getOrderList(OrderReqDto orderReqDto){
        OrderResListDto result = orderSvc.selectOrderList(orderReqDto);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{ordId}")
    public ResponseEntity<OrderResDetailDto> getOrderDetail(@PathVariable String ordId){
        OrderResDetailDto result = orderSvc.selectOrderDetail(ordId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
