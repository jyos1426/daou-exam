package com.example.demo.controller;

import java.util.List;

import com.example.demo.error.CustomException;
import com.example.demo.error.ErrorCode;
import com.example.demo.service.OrgService;
import com.example.demo.vo.Organization;
import com.example.demo.vo.SimpleOrganization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * @param deptCode 최상위 부서코드
     * @param deptOnly 부서 정보만 응답 여부
     * @param searchType 검색 대상 ("dept": 부서, "member": 부서원)
     * @param searchKeyword 검색어
     * @return List<Organization>
     */
    @GetMapping("/organizations")
    @ResponseBody
    public List<Organization> getOrgList(
            @RequestParam(value = "deptCode", required = false) String deptCode,
            @RequestParam(value = "deptOnly", required = false,
                    defaultValue = "false") Boolean deptOnly,
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {

            if(searchType == null) {
                throw new CustomException(ErrorCode.INTER_SERVER_ERROR);
            }

            List<Organization> list = orgService.getOrgList(deptCode, deptOnly, searchType, searchKeyword);
            return list;                
    }

    /**
     * 
     * @param type (0: Company, 1: 부서, 2: 팀, 3: 직원)
     * @param name
     * @param manager
     * @param parentId
     * @return 추가된 조직(부서, 멤버) 정보
     */
    @PostMapping("/dept")
    @ResponseBody
    public SimpleOrganization addDepartment(@RequestBody() SimpleOrganization department) {
        return orgService.addOrganization(department);
    }

    /**
     * 
     * @param type 0: Company, 1: 부서, 2: 팀, 3: 직원
     * @param name
     * @param manager
     * @param parentId
     * @return 삭제된 조직(부서, 멤버) id
     */
    @PutMapping("/dept/{id}")
    @ResponseBody
    public SimpleOrganization modDepartment(@PathVariable int id, @RequestBody() SimpleOrganization department){
        return orgService.modOrganization(id, department);
    }

    /**
     * 
     * @param type 0: Company, 1: 부서, 2: 팀, 3: 직원
     * @param name
     * @param manager
     * @param parentId
     * @return 삭제된 조직(부서, 멤버) id
     */
    @DeleteMapping("/dept/{id}")
    @ResponseBody
    public int delDepartment(@PathVariable int id){
        return orgService.delOrganization(id);
    }

    /**
     * 
     * @param type (0: Company, 1: 부서, 2: 팀, 3: 직원)
     * @param name
     * @param manager
     * @param parentId
     * @return 추가된 조직(부서, 멤버) 정보
     */
    @PostMapping("/member")
    @ResponseBody
    public SimpleOrganization addMember(@RequestBody() SimpleOrganization department) {
        return orgService.addOrganization(department);
    }

    /**
     * 
     * @param type 0: Company, 1: 부서, 2: 팀, 3: 직원
     * @param name
     * @param manager
     * @param parentId
     * @return 삭제된 조직(부서, 멤버) id
     */
    @PutMapping("/member/{id}")
    @ResponseBody
    public SimpleOrganization modMember(@PathVariable int id, @RequestBody() SimpleOrganization department){
        return orgService.modOrganization(id, department);
    }

    /**
     * 
     * @param type 0: Company, 1: 부서, 2: 팀, 3: 직원
     * @param name
     * @param manager
     * @param parentId
     * @return 삭제된 조직(부서, 멤버) id
     */
    @DeleteMapping("/member/{id}")
    @ResponseBody
    public int delMember(@PathVariable int id){
        return orgService.delOrganization(id);
    }
}
