package com.example.demo.mapper;

import com.example.demo.vo.Organization;
import com.example.demo.vo.SimpleOrganization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrgMapper {
    List<Organization> getOrgList(String deptCode, String searchType, boolean deptOnly);

    SimpleOrganization getOneById(int id);

    void insertOrganization(SimpleOrganization org);

    void updateOrganization(Number orgId, SimpleOrganization organization);

    void deleteOrganization(int orgId);
}
