package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.City;
import com.example.demo.model.Project;
import com.example.demo.service.InfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class InfoController {

    private InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        // 생성자 주입 이유
        // 순환참조 방지 : A가 B를 참조하고 B가 A를 참조할 때의 문제
        // 테스트하기에 좋음
        // final 선언 가능
        // 오류 방지 : 불변 객체 (final) 또는 null 방지 가능

        this.infoService = infoService;
    }

    @GetMapping("/api/info")
    public Object projectInfo() {
        Project project = infoService.getProjectInfo();
        return project;
    }

    @GetMapping("/cityList")
    public Object cityList() {
        List<City> cityList = infoService.getCityList();
        return cityList;
    }
}
