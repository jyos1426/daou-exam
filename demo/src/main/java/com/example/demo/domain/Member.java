package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 사원 Entity
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Getter
@Setter
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
