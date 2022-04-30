package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "조직 Id", dataType = "int", required = false)
    private int orgId;

    @ApiModelProperty(value = "상위 조직 Id", dataType = "int", required = true)
    private int parentOrgId;

    @ApiModelProperty(value = "부서 이름", dataType = "int", required = true)
    private String name;

    @ApiModelProperty(value = "부서 코드", dataType = "string", required = true)
    private String code;

    /**
     * Company, Division, Department
     */
    @ApiModelProperty(value = "부서 타입", dataType = "int", required = true)
    private String type;
}
