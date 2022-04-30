package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 사원 DTO
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Getter
@Setter
public class MemberDto {
    /**
     * 조직 Id
     */
    private int orgId;

    /**
     * 상위 조직 Id
     */
    private int parentOrgId;

    /**
     * 사원명
     */
    private String name;

    /**
     * 조직 타입 (Manager)
     */
    private String type;

    /**
     * 관리자 여부
     */
    private boolean manager;
}
