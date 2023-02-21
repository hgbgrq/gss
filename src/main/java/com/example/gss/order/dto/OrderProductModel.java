package com.example.gss.order.dto;

import lombok.Data;

@Data
public class OrderProductModel {

    private String prdId;
    private String ordId;
    private String prdStyleNo;
    private String prdItem;
    private String prdSize;
    private String prdColor;
    private String prdQty;
    private String prdPrc;
    private String prdEtc;

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getPrdStyleNo() {
        return prdStyleNo;
    }

    public void setPrdStyleNo(String prdStyleNo) {
        this.prdStyleNo = prdStyleNo;
    }

    public String getPrdItem() {
        return prdItem;
    }

    public void setPrdItem(String prdItem) {
        this.prdItem = prdItem;
    }

    public String getPrdSize() {
        return prdSize;
    }

    public void setPrdSize(String prdSize) {
        this.prdSize = prdSize;
    }

    public String getPrdColor() {
        return prdColor;
    }

    public void setPrdColor(String prdColor) {
        this.prdColor = prdColor;
    }

    public String getPrdQty() {
        return prdQty;
    }

    public void setPrdQty(String prdQty) {
        this.prdQty = prdQty;
    }

    public String getPrdPrc() {
        return prdPrc;
    }

    public void setPrdPrc(String prdPrc) {
        this.prdPrc = prdPrc;
    }

    public String getPrdEtc() {
        return prdEtc;
    }

    public void setPrdEtc(String prdEtc) {
        this.prdEtc = prdEtc;
    }
}
