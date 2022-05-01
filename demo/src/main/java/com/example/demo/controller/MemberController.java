package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 사원 API Controller
 *
 * @author hyeon
 * @since 2022-04-30
 */
@Api(tags = "MemberController", description = "사원 CUD Controller")
@RequestMapping("/org")
@Controller
public class MemberController {

    final private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * @param member 추가할 사원 정보
     * @return 추가된 사원 정보
     */
    @ApiOperation(value = "사원 추가 API")
    @PostMapping("/member")
    @ResponseBody
    public MemberDto addMember(
        @RequestBody() 
        @ApiParam(value = "추가할 부서 정보", required = true) MemberDto member) {
        return memberService.addMember(member);
    }

    /**
     * @param orgId 수정할 사원의 조직 Id
     * @param member 수정할 사원 정보
     * @return 수정된 사원 정보
     */
    @ApiOperation(value = "사원 정보 수정 API")
    @PutMapping("/member/{orgId}")
    @ResponseBody
    public MemberDto modMember(
        @PathVariable 
        @ApiParam(value = "수정할 사원의 조직 Id", required = true) int orgId, 
        @RequestBody() 
        @ApiParam(value = "수정할 사원 정보", required = true) MemberDto member) {
        return memberService.modMember(orgId, member);
    }

    /**
     * @param orgId 삭제할 사원의 조직 Id
     * @return 삭제된 사원의 Id
     */
    @ApiOperation(value = "사원 삭제 API")
    @DeleteMapping("/member/{orgId}")
    @ResponseBody
    public int delMember(
        @PathVariable 
        @ApiParam(value = "삭제할 사원의 조직 Id", required = true) int orgId) {
        return memberService.delMember(orgId);
    }
}
