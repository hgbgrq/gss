package com.example.gss.file.dto.res;

import lombok.Data;

import java.util.List;

@Data
public class FileOrderInfoResList {

    String fileId;

    List<FileOrderInfo> list;

}
