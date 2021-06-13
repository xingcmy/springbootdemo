package com.example.demo.service.servers.serives;

import com.example.demo.service.servers.tools.Star;
import com.example.demo.service.servers.tools.msg.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MsgServer<K> {
    private Map<String,Object> msgMap = new HashMap<>();

    @Autowired
    private Star star;
    public K setMsg(Map<String,Object> object){
        if (object == null)
            throw new Error("it is null");
        for (;;){
            synchronized (msgMap){
                if (msgMap.size()<=0){
                    List<Msg> msgList = new ArrayList<>();
                    setMsgMap(object,msgList);
                }else {
                    if (msgMap.get(object.get(star.username).toString())!=null){
                        List<Msg> msgList = (List<Msg>) msgMap.get(object.get(star.username).toString());
                        setMsgMap(object,msgList);
                    }else {
                        List<Msg> msgList = new ArrayList<>();
                        setMsgMap(object,msgList);
                    }
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
