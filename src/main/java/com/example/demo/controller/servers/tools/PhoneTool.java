package com.example.demo.controller.servers.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PhoneTool {

    @Value("${criterion.phone}")
    private String criterion;

    public boolean isPhone(String phone){
        if(phone.matches(criterion)){
            return true;
        }
        return false;
    }
}
