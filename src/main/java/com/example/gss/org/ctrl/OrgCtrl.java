package com.example.gss.org.ctrl;

import com.example.gss.org.dto.req.OrgReq;
import com.example.gss.org.dto.res.OrgDetailRes;
import com.example.gss.org.dto.res.OrgResList;
import com.example.gss.org.svc.OrgSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/org")
public class OrgCtrl {

    @Autowired
    private OrgSvc orgSvc;

    @GetMapping
    public ResponseEntity<OrgResList> getOrgList(OrgReq orgReq){
        OrgResList result = orgSvc.selectOrgList(orgReq);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{orgId}")
    public ResponseEntity<OrgDetailRes> getOrgDetail(@PathVariable String orgId){
        OrgDetailRes result = new OrgDetailRes();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
