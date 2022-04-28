package com.example.demo.controller;

import java.util.List;

import com.example.demo.service.OrgService;
import com.example.demo.vo.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/org")
@Controller
public class OrganizationController {

    private OrgService orgService;

    @Autowired
    public OrganizationController(OrgService orgService) {
        this.orgService = orgService;
    }

    /**
     * 
     * @param deptCode 기준 부서코드. 미입력시 최상위 노드를 기준으로 조회
     * @param deptOnly 부서 정보만 응답 여부
     * @param searchType 검색 대상 ("dept": 부서, "member": 부서원)
     * @param searchKeyword 검색어
     * @return id, type, name, code, manager, children
     */
    @GetMapping("/organizations")
    @ResponseBody
    public List<Organization> getList(
            @RequestParam(value = "deptCode", required = false) String deptCode,
            @RequestParam(value = "deptOnly", required = false,
                    defaultValue = "false") Boolean deptOnly,
            @RequestParam(value = "searchType", required = false,
                    defaultValue = "false") String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {
        System.out.println(String.format("%-10s%-10s", deptCode, searchType));
        System.out.println(deptOnly);
        return orgService.getList(deptCode, deptOnly, searchType, searchKeyword);
    }

}
