package com.example.demo.controller;

import com.example.demo.dto.OrganizationDto;
import com.example.demo.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.ApiOperation;

/**
 * 조직도 API Controller
 *
 * @author hyeon
 * @since 2022-04-30
 */
@RequestMapping("/org")
@Controller
public class OrgController {

    final private OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    /**
     * 조직도 트리 데이터 조회 API
     * 
     * @param deptCode 최상위 부서 코드
     * @param deptOnly 부서 정보만 응답 여부
     * @param searchType 검색어 적용 대상 ("dept": 부서, "member": 부서원)
     * @param searchKeyword 검색어
     * @return OrganizationTree
     */
    @ApiOperation(value = "조직도 트리 데이터 조회 API")
    @GetMapping("/organizations")
    @ResponseBody
    public OrganizationDto getOrgTree(
            @RequestParam(value = "deptCode", required = false) String deptCode,
            @RequestParam(value = "deptOnly", required = false,
                    defaultValue = "false") Boolean deptOnly,
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {

        OrganizationDto treeData =
                orgService.getOrgTree(deptCode, deptOnly, searchType, searchKeyword);
        return treeData;
    }
}
