package com.example.demo.service;

import com.example.demo.vo.Organization;
import com.example.demo.vo.SimpleOrganization;

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

    public List<Organization> getOrgList(String deptCode, boolean deptOnly, String searchType,
            String searchKeyword) {
        List<Organization> orgList = orgMapper.getOrgList(deptCode, searchType, deptOnly);
        return orgList;
    }


    public SimpleOrganization addOrganization(SimpleOrganization dept) {
        orgMapper.insertOrganization(dept);
        return orgMapper.getOneById(dept.getId());
    }


    public SimpleOrganization modOrganization(int orgId, SimpleOrganization dept) {
        orgMapper.updateOrganization(orgId, dept);
        return orgMapper.getOneById(orgId);
    }


    public int delOrganization(int orgId) {
        orgMapper.deleteOrganization(orgId);
        return orgId;
    }

}
