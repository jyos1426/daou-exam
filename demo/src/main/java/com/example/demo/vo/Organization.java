package com.example.demo.vo;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.MemberDto;
import lombok.Data;

/**
 * 조직 관계 Entity
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Data
public class Organization {
    public Organization(DepartmentDto dept) {
        this.orgType = dept.getType();
        this.orgId = dept.getOrgId();
        this.parentOrgId = dept.getParentOrgId();
    }

    public Organization(String type, MemberDto member) {
        this.orgType = type;
        this.parentOrgId = member.getParentOrgId();
    }

    public Organization(MemberDto member) {
        this.orgType = "Member";
        this.orgId = member.getOrgId();
        this.parentOrgId = member.getParentOrgId();
    }

    public Organization(int orgId, String type, int parentOrgId) {
        this.orgType = type;
        this.orgId = orgId;
        this.parentOrgId = parentOrgId;
    }

    /**
     * 조직 Id
     */
    private int orgId;

    /**
     * 조직 Id
     */
    private String orgType;

    /**
     * 조직 Id
     */
    private int parentOrgId;
}
