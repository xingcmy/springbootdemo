package com.example.demo.service.servers.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailTool {

    @Value("${criterion.email}")
    private String criterion;
    public boolean isEmail(String email){
        Pattern p;
        Matcher m;
        p = Pattern.compile(criterion);
        m = p.matcher(email);
        if (m.matches()){
            return true;
        }
        return false;
    }
}
