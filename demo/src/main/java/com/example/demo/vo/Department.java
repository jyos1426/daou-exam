package com.example.demo.vo;

import com.example.demo.dto.DepartmentDto;
import lombok.Data;

/**
 * 부서 Entity
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Data
public class Department {
    public Department(DepartmentDto deptDto) {
        this.orgId = deptDto.getOrgId();
        this.deptCode = deptDto.getCode();
        this.deptName = deptDto.getName();
        this.deptType = deptDto.getType();
    }

    /**
     * 조직 Id
     */
    private int orgId;

    /**
     * 부서 코드
     */
    private String deptCode;

    /**
     * 부서명
     */
    private String deptName;

    /**
     * 조직 유형 ("Company", "Division", "Department")
     */
    private String deptType;
}
