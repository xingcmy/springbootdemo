package com.example.demo.service.impl;

import com.example.demo.service.servers.serives.MsgServer;
import com.example.demo.service.servers.tools.Star;
import com.example.demo.service.servers.tools.msg.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MsgServerImpl implements MsgServer {
    private Map<String,Object> msgMap = new HashMap<>();

    @Autowired
    private Star star;
    @Override
    public Map<String,Object>  setMsg(Map<String,Object> object){
        if (object == null)
            throw new Error("it is null");
        for (;;){
                if (object.size()<=0){
                    List<Msg> msgList = new ArrayList<>();
                    setMsgMap(object,msgList);
                }else {
                    if (object.get(object.get(star.username).toString())!=null){
                        List<Msg> msgList = (List<Msg>) object.get(object.get(star.username).toString());
                        setMsgMap(object,msgList);
                    }else {
                        List<Msg> msgList = new ArrayList<>();
                        setMsgMap(object,msgList);
                    }
                }
        }
    }

    private void setMsgMap(Map<String,Object> object,List<Msg> list){
        Msg msg=new Msg(object.get(star.msg).toString(),object.get(star.set).toString(),object.get(star.type).toString());
        list.add(msg);
        msgMap.put(object.get(star.username).toString(),list);
    }
}
