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

    @ApiModelProperty(notes = "조직 Id", dataType = "Integer", required = false, example = "null")
    private int orgId;

    @ApiModelProperty(notes = "상위 조직 Id", dataType = "Integer", required = true, example = "10")
    private int parentOrgId;

    @ApiModelProperty(notes = "사원명", dataType = "String", required = true, example = "김다우")
    private String name;

    @ApiModelProperty(notes = "조직 유형", dataType = "String", required = false, example = "Manager")
    private String type;

    @ApiModelProperty(notes = "관리자 여부", dataType = "boolean", required = true, example = "false")
    private boolean manager;
}
