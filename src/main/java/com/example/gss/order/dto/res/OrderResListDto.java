package com.example.gss.order.dto.res;

import com.example.gss.order.dto.OrderModel;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Data
public class OrderResListDto {

    private Integer totalCount;

    private List<OrderModel> list;

    public String toStringJson() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
