package com.example.demo.service.servers.tools;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Star {


    @Value("${star.username}")
    public String username;

    @Value("${star.password}")
    public String password;

    @Value("${star.email}")
    public String email;

    @Value("${star.phone}")
    public String phone;

    @Value("${star.id}")
    public String id;

    @Value("${star.time.char}")
    public String time;

    @Value("${star.time.number}")
    public Integer times;

    @Value("${star.map.code}")
    public String code;

    @Value("${star.map.data}")
    public String data;

    @Value("${star.map.key}")
    public String key;

    @Value("${star.map.type}")
    public String type;

    @Value("${star.msg.send}")
    public String send;

    @Value("${star.msg.msg}")
    public String msg;

    @Value("${star.msg.set}")
    public String set;

    @Value("${star.success.char}")
    public String success;

    @Value("${star.fail.char}")
    public String fail;
}
