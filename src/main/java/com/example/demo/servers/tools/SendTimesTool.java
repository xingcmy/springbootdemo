package com.example.demo.servers.tools;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
public class SendTimesTool {

    @Autowired
    private Star star;

    private Map<String,Object> object;

    public Map<String,Object> setLoginTime(){
        object.put(star.time,star.times);
        return object;
    }
}
