package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    private String id;
    private String phone;
    private String password;
    private String email;
    private byte[] head;
}
