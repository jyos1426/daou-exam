package com.example.demo.vo;

import java.util.List;
import lombok.Data;

@Data
public class Organization {
    private int id;

    private int type;

    private String name;

    private String code;

    private Boolean manager;

    private int parentId;

    private List<Organization> children;
}
