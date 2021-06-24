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
public interface MsgServer {

    Map<String,Object> msgMap = new HashMap<>();
    Star star = new Star();
    Map<String,Object> setMsg(Map<String,Object> object);

    private void setMsgMap(Map<String, Object> object, List<Msg> list) {
        Msg msg=new Msg(object.get(star.msg).toString(),object.get(star.set).toString(),object.get(star.type).toString());
        list.add(msg);
        msgMap.put(object.get(star.username).toString(),list);
    }
}
