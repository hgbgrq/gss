package com.example.gss.org.svc;

import com.example.gss.org.dao.OrgDao;
import com.example.gss.org.dto.req.OrgReq;
import com.example.gss.org.dto.res.OrgRes;
import com.example.gss.org.dto.res.OrgResList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgSvc {

    @Autowired
    private OrgDao orgDao;

    public OrgResList selectOrgList(OrgReq orgReq){

        OrgResList result = new OrgResList();

        List<OrgRes> list = orgDao.selectOrgList(orgReq);

        Integer totalCount = orgDao.selectOrgCount(orgReq);

        result.setList(list);
        result.setTotalCount(totalCount);

        return result;

    }

}
