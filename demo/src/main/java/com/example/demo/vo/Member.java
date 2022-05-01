package com.example.demo.vo;

import com.example.demo.dto.MemberDto;
import lombok.Data;

/**
 * 사원 Entity
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Data
public class Member {
    public Member(MemberDto memberDto) {
        this.orgId = memberDto.getOrgId();
        this.memName = memberDto.getName();
        this.manager = memberDto.isManager();
    }

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
}
