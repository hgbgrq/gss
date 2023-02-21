package com.example.gss.order.dto.req;

import lombok.Data;

import java.util.List;

@Data
public class OrderEnrollInfoReq {

    private String orgId;

    private String orderingDate;

    private String deadLineDate;

    private List<OrderEnrollProductReq> productList;
}
