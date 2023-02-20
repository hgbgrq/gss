package com.example.gss.file.dao;

import com.example.gss.file.dto.FileOrganization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileDao {

    List<FileOrganization> selectOrgInfos(String orgTmpNm);

}
