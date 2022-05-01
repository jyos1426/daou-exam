package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 부서 DTO
 *
 * @author hyeon
 * @since 2022-04-30
 */
@ApiModel(description = "부서 DTO")
@Getter
@Setter
public class DepartmentDto {

    @ApiModelProperty(notes = "조직 Id", dataType = "Integer", required = false, example = "null")
    private int orgId;

    @ApiModelProperty(notes = "상위 조직 Id", dataType = "Integer", required = true, example = "6")
    private int parentOrgId;

    @ApiModelProperty(notes = "부서 이름", dataType = "String", required = true, example = "차세대서비스개발부")
    private String name;

    @ApiModelProperty(notes = "부서 코드", dataType = "String", required = true, example = "A22000")
    private String code;

    /**
     * Company, Division, Department
     */
    @ApiModelProperty(value = "부서 타입", dataType = "String", required = true, example = "Division")
    private String type;
}
