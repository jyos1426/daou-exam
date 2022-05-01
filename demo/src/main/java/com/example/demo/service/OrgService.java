package com.example.demo.service;

import com.example.demo.dto.OrganizationDto;
import com.example.demo.vo.OrganizationInfo;

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
    public OrganizationDto getOrgTree(String deptCode, boolean deptOnly, String searchType,
            String searchKeyword) {

        // 최상위 노드 조회 (searchKeyword 가 있을 경우에는 최상위 노드 = 회사)
        List<OrganizationInfo> orgTopNodeList =
                orgMapper.getOrgTopNode(searchKeyword == null ? deptCode : null);
        if (orgTopNodeList.size() == 0) {
            throw new CustomException(ErrorCode.BAD_REQUEST,
                    "'" + deptCode + "'코드로 조회된 리스트가 없습니다. 조건을 확인해주세요.");
        }

        // searchKeyword와 searchType이 있을 경우, 필터링할 idList Select
        List<Integer> searchedIdList = null;
        if (!(searchKeyword == null || searchType == null)) {
            if (searchKeyword == null || searchType == null) {
                throw new CustomException(ErrorCode.BAD_REQUEST,
                        "searchkeyword를 입력 시 searchType이 존재해야합니다.");
            }
            searchedIdList = orgMapper.getOrgIdListByKeyword(searchType, searchKeyword);
            if (searchedIdList.size() == 0) {
                throw new CustomException(ErrorCode.BAD_REQUEST,
                        "'" + searchKeyword + "' 검색어로 조회된 리스트가 없습니다.");
            }
        }

        // 재귀 방식으로 Children 조회
        OrganizationDto orgTopNode = new OrganizationDto(orgTopNodeList.get(0));
        orgTopNode.setChildren(
                getChildrenByParentId(orgTopNode.getOrgId(), deptOnly, searchedIdList));

        return orgTopNode;
    }

    /**
     * 조직 트리 children 조회 함수
     * 
     * @param parentOrgId
     * @param deptOnly
     * @param searchedIdList
     * @return
     */
    private List<OrganizationDto> getChildrenByParentId(int parentOrgId, boolean deptOnly,
            List<Integer> searchedIdList) {
        // List 초기화
        List<OrganizationDto> filteredChildren = new ArrayList<OrganizationDto>();

        // 조건에 맞는 Child Node Select
        List<OrganizationInfo> selectedChildrenList =
                orgMapper.getOrgChildrenNode(parentOrgId, deptOnly, searchedIdList);

        // 재귀 함수 호출, Dto List 로 변환
        for (OrganizationInfo childNode : selectedChildrenList) {
            OrganizationDto childDto = new OrganizationDto(childNode);
            childDto.setChildren(
                    getChildrenByParentId(childNode.getOrgId(), deptOnly, searchedIdList));
            filteredChildren.add(childDto);
        }

        return filteredChildren;
    }
}
