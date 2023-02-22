package com.example.gss.org.dao;

import com.example.gss.org.dto.req.OrgReq;
import com.example.gss.org.dto.res.OrgRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrgDao {


    List<OrgRes> selectOrgList(OrgReq orgReq);

    Integer selectOrgCount(OrgReq orgReq);

}
