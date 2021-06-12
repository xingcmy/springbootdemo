package com.example.demo.dao.friend;

import lombok.Data;

@Data
public class Friends {

    private String id;

    private String friend;

    public Friends(String id, String friend) {
        this.id = id;
        this.friend = friend;
    }
}
