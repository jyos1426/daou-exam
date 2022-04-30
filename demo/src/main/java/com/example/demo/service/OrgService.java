package com.example.demo.service;
import com.example.demo.entity.OrganizationTree;

import com.example.demo.mapper.OrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 조직 Service 클래스
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Service
public class OrgService {

    @Autowired
    OrgMapper orgMapper;

    public OrgService(OrgMapper orgMapper) {
        this.orgMapper = orgMapper;
    }

    /**
     * 조직 트리 조회 Service
     * 
     * @param deptCode 최상위 부서 코드
     * @param deptOnly 부서 정보만 응답 여부
     * @param searchType 검색어 적용 대상 ("dept": 부서, "member": 부서원)
     * @param searchKeyword 검색어
     * @return
     */
    public OrganizationTree getOrgTree(String deptCode, boolean deptOnly, String searchType,
            String searchKeyword) {
        List<OrganizationTree> getOrgTree = orgMapper.getOrgTree(deptCode, deptOnly, searchType, searchKeyword);
        return getOrgTree.get(0);
    }
}
