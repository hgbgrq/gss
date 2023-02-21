package com.example.gss.file.dto.res;

import lombok.Data;

import java.util.List;

@Data
public class FileDetailOrderRes {

    private String orgId;

    private String orgName;

    private String orderingDate;

    private String deadLineDate;

    private List<FileDetailProduct> productList;

}
