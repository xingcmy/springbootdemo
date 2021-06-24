package com.example.demo.service.impl;

import com.example.demo.service.servers.serives.LoginServer;
import com.example.demo.service.servers.tools.BooleanTool;
import com.example.demo.service.servers.tools.SendIDTool;
import com.example.demo.service.servers.tools.SendTimesTool;
import com.example.demo.service.servers.tools.Star;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Log
public class LoginServerImpl implements LoginServer {

    @Autowired
    private BooleanTool booleanTool;

    @Autowired
    private SendTimesTool sendTimesTool;

    @Autowired
    private SendIDTool sendIDTool;

    @Autowired
    private Star star;

    @Override
    public boolean logIn(Map<String,Object> object){
        if (!booleanTool.isNullOrFalse(object)){
            String password = object.get(star.password).toString();
            while (true){
                /**
                 * 待改进
                 */
                String username=object.get(star.username).toString();
                sendIDTool.setObject(object);
                sendIDTool.getObject(username);
                if (object!=null){
                    break;
                }
                return false;

            }
            if (booleanTool.compareAndEquality(password,object.get(star.password).toString()) == 1){
                sendTimesTool.setObject(object);
                object=sendTimesTool.setLoginTime();
                log.info(object.toString());
                booleanTool.isTimeToLong(object);
                return true;
            }
        }
        return false;
    }
}
