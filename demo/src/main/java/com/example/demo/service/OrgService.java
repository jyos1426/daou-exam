package com.example.demo.service;

import com.example.demo.vo.Organization;
import com.example.demo.mapper.OrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgService {

    @Autowired
    OrgMapper orgMapper;

    public OrgService(OrgMapper orgMapper) {
        this.orgMapper = orgMapper;
    }

    public List<Organization> getList(String deptCode, boolean deptOnly, String searchType,
            String searchKeyword) {
        List<Organization> orgList = orgMapper.getList(deptCode, deptOnly);
        return orgList;
    }

}
