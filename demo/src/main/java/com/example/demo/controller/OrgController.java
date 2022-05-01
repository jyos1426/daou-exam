package com.example.demo.controller;

import com.example.demo.dto.OrganizationDto;
import com.example.demo.service.OrgService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

/**
 * 조직도 API Controller
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Api(tags = "OrgController", description = "조직도 조회 Controller")
@RequestMapping("/org")
@RestController
@RequiredArgsConstructor
public class OrgController {
    
    final private OrgService orgService;

    /**
     * @param deptCode 최상위 부서 코드
     * @param deptOnly 부서 정보만 응답 여부
     * @param searchType 검색어 적용 대상 ("dept": 부서, "member": 부서원)
     * @param searchKeyword 검색어
     * @return OrganizationTree
     */
    @ApiOperation(value = "조직도 트리 데이터 조회 API")
    @GetMapping("/organizations")
    public OrganizationDto getOrgTree(
            @RequestParam(value = "deptCode", required = false)
            @ApiParam(value = "최상위 부서 코드", required = false) String deptCode,
            @RequestParam(value = "deptOnly", required = false, defaultValue = "false") 
            @ApiParam( value = "부서 정보만 응답 여부", required = false) Boolean deptOnly,
            @RequestParam(value = "searchType", required = false) 
            @ApiParam(value = "검색어 적용 대상 (dept: 부서, member: 부서원)", required = true) String searchType,
            @RequestParam(value = "searchKeyword", required = false) 
            @ApiParam(value = "검색어", required = false) String searchKeyword) {

        OrganizationDto treeData =
                orgService.getOrgTree(deptCode, deptOnly, searchType, searchKeyword);
        return treeData;
    }
}
