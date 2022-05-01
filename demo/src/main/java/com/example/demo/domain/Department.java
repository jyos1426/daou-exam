package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 부서 Entity
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Getter
@Setter
public class Department {
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

    public Department(int orgId, String deptCode, String deptName, String deptType) {
        this.orgId = orgId;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.deptType = deptType;
    }

}
