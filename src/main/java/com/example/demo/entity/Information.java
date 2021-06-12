package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Information {
    @Id
    private String id;
    private String name;
    private String signature;
    private String sex;
    private String birthday;
    private String profession;
    private String city;
}
