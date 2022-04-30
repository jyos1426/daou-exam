package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "조직 Id", dataType = "int", required = false)
    private int orgId;

    @ApiModelProperty(value = "상위 조직 Id", dataType = "int", required = true)
    private int parentOrgId;

    @ApiModelProperty(value = "사원명", dataType = "string", required = true)
    private String name;

    @ApiModelProperty(value = "조직 유형", dataType = "string", required = false)
    private String type;

    @ApiModelProperty(value = "관리자 여부", dataType = "boolean", required = false)
    private boolean manager;
}
