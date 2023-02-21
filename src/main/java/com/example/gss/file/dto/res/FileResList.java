package com.example.gss.file.dto.res;

import lombok.Data;

import java.util.List;

@Data
public class FileResList {

    Integer totalCount;

    List<FileRes> list;
}
