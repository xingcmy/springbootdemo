package com.example.demo.dao.information;

import lombok.Data;

@Data
public class Information {

    private String id;

    private String name;

    private String signature;

    private String sex;

    private String birthday;

    private String profession;

    private String city;

    public Information(String id, String name, String signature, String sex, String birthday, String profession, String city) {
        this.id = id;
        this.name = name;
        this.signature = signature;
        this.sex = sex;
        this.birthday = birthday;
        this.profession = profession;
        this.city = city;
    }


}
