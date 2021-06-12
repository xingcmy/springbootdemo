package com.example.demo.controller.servers.serives;

import com.example.demo.controller.servers.tools.BooleanTool;
import com.example.demo.controller.servers.tools.SendIDTool;
import com.example.demo.controller.servers.tools.Star;
import com.example.demo.dao.InsertDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RegisterServer {

    @Autowired
    private InsertDB insertDB;

    @Autowired
    private Star star;

    @Autowired
    private SendIDTool sendIDTool;

    @Autowired
    private BooleanTool booleanTool;

    private Map<String,Object> object;

    public boolean register(){
        if (object==null)
            return false;
        byte[] bytes=null;
        if (insertDB.insertUser(object.get(star.phone).toString(),object.get(star.password).toString(),
                object.get(star.id).toString(),object.get(star.email).toString(),bytes) == 1){
            return true;
        }
        return false;
    }

    public Map<String, Object> getObject() {
        return object;
    }

    public void setObject(Map<String, Object> object) {
        sendIDTool.setObject(object);
        this.object=sendIDTool.getID();
    }
}
