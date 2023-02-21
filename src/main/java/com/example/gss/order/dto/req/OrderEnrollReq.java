package com.example.gss.order.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class OrderEnrollReq {

    private String fileId;

    List<OrderEnrollInfoReq> list;


}
