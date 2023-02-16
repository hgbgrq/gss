package com.example.gss.order.dto.res;

import com.example.gss.order.dto.OrderProductModel;
import lombok.Data;

import java.util.List;

@Data
public class OrderResDetailDto {

    private String orderId;
    private String orgId;
    private String orgName;
    private String ordOrderingDate;
    private String ordFileId;
    private String ordDeadLineDate;
    private String ordFileName;
    private List<OrderProductModel> list;

}
