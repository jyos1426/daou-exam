package com.example.demo.service;
import com.example.demo.entity.OrganizationTree;
import com.example.demo.error.ErrorCode;
import com.example.demo.error.exception.CustomException;
import com.example.demo.mapper.OrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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

        List<OrganizationTree> orgTreeList = orgMapper.getOrgTree(null, false);
        if(orgTreeList.size() == 0){
            throw new CustomException(ErrorCode.BAD_REQUEST, "조회된 리스트가 없습니다. 조건을 확인해주세요.");            
        }

        if(!(searchKeyword == null || searchType == null)){
            if(searchKeyword == null || searchType == null){
                throw new CustomException(ErrorCode.BAD_REQUEST, "searchkeyword를 입력 시 searchType이 존재해야합니다.");            
            }
            List<Integer> searchedIdList = orgMapper.getOrgIdListByKeyword(searchType, searchKeyword);
            
            return filterOrgTree(orgTreeList.get(0), searchedIdList);
        }
        return orgTreeList.get(0);
    }
    
    /**
     * 조직도 필터링
     * 
     * @param upper
     * @param conditionIds
     * @return 필터링된 조직도
     */
    private OrganizationTree filterOrgTree(OrganizationTree upper, List<Integer> conditionIds){
        List<OrganizationTree> filteredChildren = new ArrayList<OrganizationTree>();
        
        for(OrganizationTree childTree: upper.getChildren()){
            if(conditionIds.indexOf(childTree.getOrgId()) >-1){
                filteredChildren.add( filterOrgTree(childTree, conditionIds) );             
            }
        }
        upper.setChildren(filteredChildren);
        return upper;
    }
}
