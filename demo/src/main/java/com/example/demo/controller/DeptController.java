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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 부서 API Controller
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Api(tags = "DeptController", description = "부서 CUD Controller")
@RequestMapping("/org")
@Controller
public class DeptController {

    private DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * @param dept 추가할 부서 정보
     * @return 추가된 부서 정보
     */
    @ApiOperation(value = "부서 추가 API")
    @PostMapping("/dept")
    @ResponseBody
    public DepartmentDto addDepartment(
            @RequestBody()
            @ApiParam(value = "추가할 부서 정보", required = true) DepartmentDto dept) {
        return deptService.addDepartment(dept);
    }

    /**
     * @param orgId 수정할 조직 Id
     * @param dept 수정할 부서 정보
     * @return 수정된 부서 정보
     */
    @ApiOperation(value = "부서 정보 수정 API")
    @PutMapping("/dept/{orgId}")
    @ResponseBody
    public DepartmentDto modDepartment(
            @PathVariable
            @ApiParam(value = "수정할 조직 Id", required = true) int orgId,
            @RequestBody()
            @ApiParam(value = "수정할 부서 정보", required = true) DepartmentDto dept) {
        return deptService.modDepartment(orgId, dept);
    }

    /**
     * @param orgId 삭제할 조직 Id
     * @param force 하위 데이터 삭제 여부 (false로 설정 시 하위 데이터가 있으면 에러를 응답한다.)
     * @return 삭제된 부서 Id 리스트 (하위 포함)
     */
    @ApiOperation(value = "부서 삭제 API")
    @DeleteMapping("/dept/{orgId}")
    @ResponseBody
    public List<Integer> delDepartment(
            @PathVariable
            @ApiParam(value = "삭제할 조직 Id", required = true) int orgId,
            @RequestParam(value = "force", required = false, defaultValue = "false")
            @ApiParam( value = "하위 데이터 삭제 여부", required = true) Boolean force) {
        return deptService.delDepartment(orgId, force);
    }
}
