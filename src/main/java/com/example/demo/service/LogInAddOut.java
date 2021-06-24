package com.example.demo.service;

import com.example.demo.service.servers.serives.LoginServer;
import com.example.demo.service.servers.tools.DataSecurity;
import com.example.demo.service.servers.tools.Star;
import com.example.demo.service.servers.tools.exceptions.NullErrorException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log
@RestController
@RequestMapping("/log")
public class LogInAddOut {
    @Autowired
    private LoginServer loginServer;
    @Autowired
    private DataSecurity dataSecurity;
    @Autowired
    private Star star;

    @PostMapping("/in")
    public Map<String,Object> login(@RequestBody Map<String,Object> objectMap){
        if (objectMap.size()<=0)
            throw new NullErrorException("The incoming value is null!");
        log.info(objectMap.toString());
        if (loginServer.logIn(objectMap)){
            return dataSecurity.setData(star.success);
        }
        return dataSecurity.setData(star.fail);
    }

    @PostMapping("/out")
    public Map<String,Object> logout(@RequestBody Map<String,Object> objectMap){
        if (objectMap.size()<=0)
            throw new NullErrorException("The incoming value is null!");
        return dataSecurity.setData(star.fail);
    }
}
