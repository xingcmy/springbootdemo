package com.example.demo.service;

import com.example.demo.service.servers.serives.AlterPasswordServer;
import com.example.demo.service.servers.tools.DataSecurity;
import com.example.demo.service.servers.tools.Star;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/{id}")
@Log
public class AlterPassword {

    @Autowired
    private AlterPasswordServer alterPasswordServer;

    @Autowired
    private DataSecurity dataSecurity;

    @Autowired
    private Star star;

    @PostMapping("/alter")
    public Map<String,Object> alterPassword(@RequestBody Map<String,Object> object){
        log.info(object.toString());
        if (alterPasswordServer.alterPassword(object)){
            return dataSecurity.setData(star.success);
        }
        return dataSecurity.setData(star.fail);

    }
}
