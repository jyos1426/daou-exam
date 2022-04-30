package com.example.demo.entity;

import java.util.List;
import lombok.Data;

/**
 * 조직도 Entity
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Data
public class OrganizationTree {
    /**
     * 조직 Id
     */
    private int orgId;

    /**
     * 조직 유형
     */
    private String type;

    /**
     * 조직 이름
     */
    private String name;

    /**
     * 조직 코드 (부서일 때)
     */
    private String code;

    /**
     * 관리자 여부(사원일 때)
     */
    private Boolean manager;

    /**
     * 하위 조직(부서 또는 사원)
     */
    private List<OrganizationTree> children;

    private Boolean deptOnly;
}
