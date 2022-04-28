package com.example.demo.mapper;

import com.example.demo.vo.Organization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrgMapper {
    List<Organization> getList(String deptCode, boolean deptOnly);
}
