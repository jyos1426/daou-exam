package com.example.demo.vo;

import lombok.Data;

@Data
public class SimpleOrganization {
    private int id;

    private int type;

    private String name;

    private String code;

    private Boolean manager;

    private int parentId;
}
