package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.example.demo.repository.CityRepository;
import com.example.demo.vo.City;
import com.example.demo.vo.Project;

@Service
public class InfoService {

    private final CityRepository cityRepository;

    @Autowired
    public InfoService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Project getProjectInfo() {

        Project project = new Project();
        project.projectName = "project name";
        project.author = "hello-hyeon";
        project.createdDate = new Date();

        return project;
    }

    public List<City> getCityList() {
        return this.cityRepository.findList();
    }
}
