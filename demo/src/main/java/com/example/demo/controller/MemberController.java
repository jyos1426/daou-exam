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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 조직도 API Controller
 *
 * @author hyeon
 * @since 2022-04-30
 */
@RequestMapping("/org")
@Controller
public class MemberController {

    final private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 사원 추가 API
     * 
     * @param member 추가할 사원 정보
     * @return 추가된 사원 정보
     */
    @PostMapping("/member")
    @ResponseBody
    public MemberDto addMember(@RequestBody() MemberDto member) {
        return memberService.addMember(member);
    }

    /**
     * 사원 정보 수정 API
     * 
     * @param orgId 수정할 사원의 조직 Id
     * @param member 수정할 사원 정보
     * @return 수정된 사원 정보
     */
    @PutMapping("/member/{orgId}")
    @ResponseBody
    public MemberDto modMember(@PathVariable int orgId, @RequestBody() MemberDto member) {
        return memberService.modMember(orgId, member);
    }

    /**
     * 사원 삭제 API
     * 
     * @param orgId 삭제할 사원의 조직 Id
     * @return 삭제된 사원의 Id
     */
    @DeleteMapping("/member/{orgId}")
    @ResponseBody
    public int delMember(@PathVariable int orgId) {
        return memberService.delMember(orgId);
    }
}
