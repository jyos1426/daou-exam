package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import com.example.demo.entity.OrganizationTree;
import com.example.demo.entity.Organization;

/**
 * 조직 DB Mapper
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Mapper
public interface OrgMapper {

    /**
     * 조직 트리 Select
     * 
     * @param deptCode
     * @param deptOnly
     * @param searchType
     * @return
     */
    List<OrganizationTree> getOrgTree(String deptCode, boolean deptOnly);

    /**
     * 검색어와 매칭되는 조직 트리 id 리스트 Select
     * 
     * @param searchKeyword
     * @return
     */
    List<Integer> getOrgIdListByKeyword(String searchType, String searchKeyword);

    /**
     * Id와 매칭되는 조직 정보 Select
     * 
     * @param orgId
     * @return
     */
    List<Organization> getOrgById(int orgId);

    /**
     * Id와 매칭되는 조직의 하위 조직 Id Select
     * 
     * @param orgId
     * @return
     */
    List<Integer> getOrgChildrenIdList(int orgId);

    /**
     * 조직 Insert
     * 
     * @param org
     * @return
     */
    int insertOrganization(Organization org);

    /**
     * 조직 정보 Update
     * 
     * @param organization
     */
    void updateOrganization(Organization organization);

    /**
     * 조직 단일 Delete
     * 
     * @param orgId
     */
    void deleteOrganization(int orgId);

    /**
     * 조직 복수 Delete
     * 
     * @param orgIds
     */
    void deleteOrganizations(List<Integer> orgIds);
}
