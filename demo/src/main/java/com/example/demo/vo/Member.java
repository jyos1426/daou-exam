package com.example.demo.vo;

import lombok.Data;

/**
 * 사원 Entity
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Data
public class Member {
    /**
     * 조직 Id
     */
    private int orgId;

    /**
     * 사원명
     */
    private String memName;

    /**
     * 관리자 여부
     */
    private boolean manager;
    
    public Member(int orgId, String memName, boolean manager) {
        this.orgId = orgId;
        this.memName = memName;
        this.manager = manager;
    }
}
