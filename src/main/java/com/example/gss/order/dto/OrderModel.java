package com.example.gss.order.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderModel {

    private String orderId;
    private String orgId;
    private String orgName;
    private List<OrderProductModel> list;

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrgId() {
        return orgId;
    }
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public List<OrderProductModel> getList() {
        return list;
    }
    public void setList(List<OrderProductModel> list) {
        this.list = list;
    }
}
