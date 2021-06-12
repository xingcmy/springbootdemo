package com.example.demo.servers;


import com.example.demo.dao.InsertDB;
import com.example.demo.dao.SelectDB;
import com.example.demo.dao.UpdateDB;
import com.example.demo.dao.user.User;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Supplier;

@RestController
@Log
public class TestV1 {

    @Autowired
    private SelectDB selectDB;

    @Autowired
    private InsertDB insertDB;

    @Autowired
    private UpdateDB updateDB;

    @PostMapping("/setName")
    public String setName(JSONObject object){
        return "1";
    }

    @RequestMapping("/db")
    private List<User> getDB(){
        return selectDB.selectUserAll();
    }
    @RequestMapping("/headBb")
    private Object getHeadDB(){
        Object flag=selectDB.selectUserHead("6666");
        if (flag==null){

            log.info("it is null");
        }
        return flag;
    }

    @RequestMapping("/friend")
    private String friend(){
        return selectDB.selectFriend("friend2","6666").toString();
    }

    @RequestMapping("/a")
    private int friends(){
        return insertDB.inertFriendId("friend1","9998");
    }

    @RequestMapping("/b")
    private int information(){
        return updateDB.updateUserPhone("18868886666","6666");
    }

    public static void main(String[] args){
        String s="123456asdfg你好我，？?,";
        for (String i: s.split("")){
            byte[] b=i.getBytes(StandardCharsets.UTF_8);
            System.out.println(b.length);
            for (byte o: b){
                System.out.println(o);
            }

            System.out.println(i);
        }

    }
}
