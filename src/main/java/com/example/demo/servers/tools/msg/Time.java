package com.example.demo.servers.tools.msg;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Time {

    private String username;

    private String time;

    @Autowired
    public Time(String username, String time) {
        this.username = username;
        this.time = time;
    }
}
