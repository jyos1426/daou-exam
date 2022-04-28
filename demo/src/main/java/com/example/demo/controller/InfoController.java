package com.example.demo.controller;

import java.util.List;
import com.example.demo.service.InfoService;
import com.example.demo.service.MemberService;
import com.example.demo.vo.City;
import com.example.demo.vo.Member;
import com.example.demo.vo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class InfoController {

    private InfoService infoService;
    private MemberService memberService;

    // 생성자 주입
    @Autowired
    public InfoController(InfoService infoService, MemberService memberService) {
        // 불변 객체 (final) 또는 null 방지 가능
        // 테스트 코드의 작성
        // final 키워드 작성 및 Lombok과의 결합
        // 순환 참조 에러 방지

        this.infoService = infoService;
        this.memberService = memberService;
    }

    @GetMapping("/info")
    public Object projectInfo() {
        Project project = infoService.getProjectInfo();
        return project;
    }

    @GetMapping("/cityList")
    public Object cityList() {
        List<City> cityList = infoService.getCityList();
        return cityList;
    }

    @GetMapping("/memberList")
    public Object memberList() {
        List<Member> memberList = memberService.getMemberList();
        return memberList;
    }
}
