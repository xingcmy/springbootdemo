package com.example.demo.controller.servers.serives;

import com.example.demo.controller.servers.tools.*;
import com.example.demo.dao.LoginSelect;
import com.example.demo.dao.SelectDB;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Log
@Data
public class LoginServer {

    @Autowired
    private LoginSelect loginSelect;

    @Autowired
    private SelectDB selectDB;

    @Autowired
    private BooleanTool booleanTool;

    @Autowired
    private EmailTool emailTool;

    @Autowired
    private PhoneTool phoneTool;

    @Autowired
    private SendTimesTool sendTimesTool;

    @Autowired
    private SendIDTool sendIDTool;

    @Autowired
    private Star star;

    @Value("${star.success.char}")
    private String success;

    @Value("${star.fail.char}")
    private String fail;

    @Getter
    @Setter
    private Map<String,Object> object;

    public LoginServer(Map<String,Object> object){
        this.object=object;
    }

    public boolean login(){
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
