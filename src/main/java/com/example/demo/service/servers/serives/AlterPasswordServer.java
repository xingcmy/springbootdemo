package com.example.demo.service.servers.serives;

import com.example.demo.dao.UpdateDB;
import com.example.demo.service.servers.tools.SendIDTool;
import com.example.demo.service.servers.tools.Star;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@Log
public class AlterPasswordServer {

    private Map<String,Object> object;

    @Autowired
    private UpdateDB updateDB;

    @Autowired
    private Star star;

    @Autowired
    private SendIDTool sendIDTool;

    public boolean alterPassword(){
        if (object==null)
            return false;
        String password=object.get(star.password).toString();
        log.info(password);
        sendIDTool.setObject(object);
        object=sendIDTool.getObject(object.get(star.username).toString());
        log.info(object.toString());
        if (updateDB.updateUserPassword(password,object.get(star.username).toString()) == 1)
            return true;
        return false;
    }
}
