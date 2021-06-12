package com.example.demo.servers.tools;

import com.example.demo.dao.LoginSelect;
import com.example.demo.dao.SelectDB;
import lombok.Data;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
public class SendIDTool {

    @Autowired
    private Star star;

    @Autowired
    private SelectDB selectDB;

    @Autowired
    private LoginSelect loginSelect;


    @Autowired
    private BooleanTool booleanTool;

    @Autowired
    private EmailTool emailTool;

    @Autowired
    private PhoneTool phoneTool;

    private Map<String,Object> object;

    public Map<String,Object> getID(){
        int id=random(1000,9999);
        while (true){
            if (selectDB.selectUserId(star.id,id+"") != null)
                id=random(1000,9999);
            else {
                object.put(star.id,id);
                return object;
            }
        }
    }

    public Map<String,Object> getObject(String username){
        String password = null;
        String id = null;
        if (emailTool.isEmail(username)){
            password=loginSelect.emailLogin(username);
            id=selectDB.selectUserId(star.email,username);
        }else if (phoneTool.isPhone(username)){
            password=loginSelect.phoneLogin(username);
            id=selectDB.selectUserId(star.phone,username);
        }else if (username.length() == 4){
            password=loginSelect.idLogin(username);
            id=selectDB.selectUserId(star.id,username);
        }
        setIdAndPassword(id,password);
        return object;
    }

    public void setIdAndPassword(String id,String password){
        object.put(star.password,password);
        object.put(star.username,id);
    }

    public static int random(int min,int max){

        return (int)(Math.random()*( max -min) +min);

    }



}
