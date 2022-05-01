package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.DepartmentDto;

import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 조직도 API Controller
 *
 * @author hyeon
 * @since 2022-04-30
 */
@RequestMapping("/org")
@Controller
public class DeptController {

    private DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 부서 추가 API
     * 
     * @param dept 추가할 부서 정보
     * @return 추가된 부서 정보
     */
    @PostMapping("/dept")
    @ResponseBody
    public DepartmentDto addDepartment(@RequestBody() DepartmentDto dept) {
        return deptService.addDepartment(dept);
    }

    /**
     * 부서 정보 수정 API
     * 
     * @param orgId 수정할 조직 Id
     * @param dept 수정할 부서 정보
     * @return 수정된 부서 정보
     */
    @PutMapping("/dept/{orgId}")
    @ResponseBody
    public DepartmentDto modDepartment(@PathVariable int orgId, @RequestBody() DepartmentDto dept) {
        return deptService.modDepartment(orgId, dept);
    }

    /**
     * 부서 삭제 API
     * 
     * @param orgId 삭제할 조직 Id
     * @param force 하위 데이터 삭제 여부 (false로 설정 시 하위 데이터가 있으면 에러를 응답한다.)
     * @return 삭제된 부서 Id 리스트 (하위 포함)
     */
    @DeleteMapping("/dept/{orgId}")
    @ResponseBody
    public List<Integer> delDepartment(@PathVariable int orgId, @RequestParam(value = "force",
            required = false, defaultValue = "false") Boolean force) {
        return deptService.delDepartment(orgId, force);
    }
}
