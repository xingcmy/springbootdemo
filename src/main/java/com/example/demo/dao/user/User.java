package com.example.demo.dao.user;

import lombok.Data;
import lombok.Getter;

@Data
public class User {

    private String phone;

    private String id;

    private String password;

    private String email;

    private byte[] head;

    public User(String phone, String id, String password, String email, byte[] head) {
        this.phone = phone;
        this.id = id;
        this.password = password;
        this.email = email;
        this.head = head;
    }

    public User(String phone, String id, String password, String email) {
        this.phone = phone;
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public User(byte[] head) {
        this.head = head;
    }

    public User(String phone, String id, String email) {
        this.phone = phone;
        this.id = id;
        this.email = email;
    }
}
