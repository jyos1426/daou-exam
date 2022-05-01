package com.example.demo.service;

import com.example.demo.domain.Department;
import com.example.demo.domain.Organization;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.OrgMapper;
import com.example.demo.error.ErrorCode;
import com.example.demo.error.exception.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 부서 Service 클래스
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Service
public class DeptService {

    @Autowired
    OrgMapper orgMapper;

    @Autowired
    DeptMapper deptMapper;

    public DeptService(OrgMapper orgMapper, DeptMapper deptMapper) {
        this.orgMapper = orgMapper;
        this.deptMapper = deptMapper;
    }

    /**
     * 부서 추가 Service
     * 
     * @param dept
     * @return 추가된 부서 정보
     */
    public DepartmentDto addDepartment(DepartmentDto dept) {

        // Exception. Type 값 Validation
        List<String> allowTypeList = new ArrayList<String>();
        allowTypeList.add("Division");
        allowTypeList.add("Team");
        allowTypeList.add("Company");

        if (allowTypeList.indexOf(dept.getType()) < 0) {
            throw new CustomException(ErrorCode.BAD_REQUEST,
                    "'" + dept.getType() + "'은 유효하지 않은 조직 유형입니다. (Company, Division, Team)");
        }

        // Exception. 상위 부서 정보 예외처리
        List<Organization> parentOrgList = orgMapper.getOrgById(dept.getParentOrgId());
        if (parentOrgList.size() == 0 || parentOrgList.get(0).getOrgType() == "Manager") {
            throw new CustomException(ErrorCode.BAD_REQUEST, "상위 부서가 정보가 올바르지 않습니다.");
        }

        Organization orgInsertData = new Organization(dept.getOrgId(), dept.getType(), dept.getParentOrgId());

        // Organizaton Table Insert
        orgMapper.insertOrganization(orgInsertData);
        final int orgId = orgInsertData.getOrgId();

        // Department Table Insert
        dept.setOrgId(orgId);
        Department deptEntity = new Department(dept.getOrgId(), dept.getCode(), dept.getName(), dept.getType());
        deptMapper.insertDepartment(deptEntity);

        return dept;
    }

    /**
     * 부서 수정 Service
     * 
     * @param dept
     * @return 수정 부서 정보
     */
    public DepartmentDto modifyDepartment(int orgId, DepartmentDto dept) {
        // Exception. 부서 정보 예외 처리
        List<Organization> orgDataList = orgMapper.getOrgById(orgId);
        if (orgDataList.isEmpty()) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "부서(" + orgId + ")가 존재하지 않습니다.");
        }

        Organization orgData = orgDataList.get(0);
        if (orgData.isMember()) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "코드(" + orgId + ")는 부서 데이터가 아닙니다.");
        }

        // Note. 상위 부서 변경 시 조직도 테이블 함께 변경
        orgData = orgDataList.get(0);
        if (orgData.getParentOrgId() != dept.getParentOrgId()) {
            Organization orgUpdateData = new Organization(dept.getOrgId(), dept.getType(), dept.getParentOrgId());
            orgMapper.updateOrganization(orgUpdateData);
        }

        // Department Table Update
        Department deptEntity = new Department(dept.getOrgId(), dept.getCode(), dept.getName(), dept.getType());
        deptMapper.updateDepartment(deptEntity);

        return dept;
    }

    /**
     * 부서 삭제 Service (트리상 하위 레벨의 데이터도 삭제된다.)
     * 
     * @param dept
     * @return 삭제된 부서 Id 리스트
     */
    public List<Integer> deleteDepartment(int orgId, boolean force) {
        // Exception. 부서 정보 예외 처리
        List<Organization> orgDataList = orgMapper.getOrgById(orgId);
        if (orgDataList.isEmpty()) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "부서(" + orgId + ")가 존재하지 않습니다.");
        }

        Organization orgData = orgDataList.get(0);
        if (orgData.isMember()) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "코드(" + orgId + ")는 부서 데이터가 아닙니다.");
        }

        // 하위 조직 확인
        List<Integer> childrenIdList = orgMapper.getOrgChildrenIdList(orgId);
        if (childrenIdList.size() > 1 && !force) {
            throw new CustomException(ErrorCode.BAD_REQUEST,
                    "하위 데이터가 존재합니다. 삭제하시려면 force 값을 지정해주세요.");
        }

        // Note. DELETE CASECADE 로 조직도 삭제 시 함께 DELETE
        orgMapper.deleteOrganizations(childrenIdList);
        return childrenIdList;
    }
}
