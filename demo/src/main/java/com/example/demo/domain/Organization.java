package com.example.demo.domain;

import lombok.Data;

/**
 * 조직 관계 Entity
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Data
public class Organization {
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

    public Organization(String type, int parentOrgId) {
        this.orgType = type;
        this.parentOrgId = parentOrgId;
    }

    public Organization(int orgId, String type, int parentOrgId) {
        this.orgType = type;
        this.orgId = orgId;
        this.parentOrgId = parentOrgId;
    }

}
