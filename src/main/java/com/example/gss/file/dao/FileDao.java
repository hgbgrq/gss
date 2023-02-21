package com.example.gss.file.dao;

import com.example.gss.file.dto.FileEnroll;
import com.example.gss.file.dto.res.FileDetailOrderRes;
import com.example.gss.file.dto.res.FileDetailRes;
import com.example.gss.file.dto.res.FileOrganization;
import com.example.gss.file.dto.res.FileRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileDao {

    List<FileOrganization> selectOrgInfos(String orgTmpNm);

    void insertFile(FileEnroll file);

    List<FileRes> selectFiles();

    Integer selectFilesCount();

    FileDetailRes selectFileDetail(String fileId);

    List<FileDetailOrderRes> selectFileDetailOrders(String fileId);

}
