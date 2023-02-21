package com.example.gss.order.dto.req;

import lombok.Data;

@Data
public class OrderEnrollProductReq {

    private String styleNo;

    private String item;

    private String size;

    private String color;

    private String qty;

    private String prc;

    private String etc;

}
