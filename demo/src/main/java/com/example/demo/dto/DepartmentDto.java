package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 부서 DTO
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Getter
@Setter
public class DepartmentDto {
    /**
     * 조직 Id
     */
    private int orgId;

    /**
     * 상위 조직 Id
     */
    private int parentOrgId;

    /**
     * 부서 이름
     */
    private String name;

    /**
     * 부서 코드
     */
    private String code;

    /**
     * 부서 타입 (Company, Division, Department)
     */
    private String type;
}
