package com.example.gss.order.dto.res;

import com.example.gss.order.dto.OrderModel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class OrderResListDto {

    private Integer totalCount;

    private List<OrderModel> list;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<OrderModel> getList() {
        return list;
    }

    public void setList(List<OrderModel> list) {
        this.list = list;
    }

    public String toStringJson() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
