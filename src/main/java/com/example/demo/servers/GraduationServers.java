package com.example.demo.servers;

import com.example.demo.dao.LoginSelect;
import com.example.demo.dao.SelectDB;
import com.example.demo.servers.serives.AlterPasswordServer;
import com.example.demo.servers.serives.LoginServer;
import com.example.demo.servers.serives.RegisterServer;
import com.example.demo.servers.tools.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Log
public class GraduationServers {

    @Autowired
    private LoginServer loginServer;

    @Autowired
    private RegisterServer registerServer;

    @Autowired
    private AlterPasswordServer alterPasswordServer;

    @Autowired
    private Star star;

    @Value("${star.success.char}")
    private String success;

    @Value("${star.fail.char}")
    private String fail;

    @Autowired
    private DataSecurity dataSecurity;

    private Map<String,Object> objectMap = new HashMap<>();

    @RequestMapping(path = "/login",method = RequestMethod.POST,
            consumes = "application/json",produces = "application/json")
    private Map<String, Object> login(@RequestBody Map<String,Object> object) {
        loginServer.setObject(object);
        if (loginServer.login()){
            dataSecurity.setData(success);
            log.info(object.toString());
//            int[] typeCode= (int[]) object.get(star.key);
//            int code=(int)object.get(star.code);
//            String data=dataSecurity.getData(object.get(star.data).toString(),code,typeCode);
            return dataSecurity.setData(success);
        }
        return dataSecurity.setData(fail);
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST,
            consumes = "application/json",produces = "application/json")
    private String register(@RequestBody Map<String,Object> object) {
        registerServer.setObject(object);
        if (registerServer.register()){
            return dataSecurity.setData(success).toString();
        }
        return dataSecurity.setData(fail).toString();
    }

    @RequestMapping(path = "/forget",method = RequestMethod.POST,
            consumes = "application/json",produces = "application/json")
    private String forgetPassword(@RequestBody Map<String,Object> object) {
        alterPasswordServer.setObject(object);
        if (alterPasswordServer.alterPassword())
            return dataSecurity.setData(success).toString();
        return dataSecurity.setData(fail).toString();
    }

    @RequestMapping(path = "/getMsg",method = RequestMethod.POST,
            consumes = "application/json",produces = "application/json")
    private String getMsg(@RequestBody Map<String,Object> object) {
        return "";
    }

    @RequestMapping(path = "/setMsg",method = RequestMethod.POST,
            consumes = "application/json",produces = "application/json")
    private String setMsg(@RequestBody Map<String,Object> object) {
        return "";
    }

    @RequestMapping(path = "/getMusic",method = RequestMethod.POST,
            consumes = "application/json",produces = "application/json")
    private String getMusic(@RequestBody Map<String,Object> object) {
        return "";
    }

    @RequestMapping(path = "/setMusic",method = RequestMethod.POST,
            consumes = "application/json",produces = "application/json")
    private String setMusic(@RequestBody Map<String,Object> object) {
        return "";
    }
}
