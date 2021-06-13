package com.example.demo.service.servers.tools;

import com.example.demo.service.servers.tools.interfaces.Compare;
import com.example.demo.service.servers.tools.interfaces.IsBoolean;
import com.example.demo.service.servers.tools.interfaces.IsLongTime;
import com.example.demo.service.servers.tools.interfaces.IsNull;
import com.example.demo.service.servers.tools.msg.Time;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Log
public class BooleanTool implements IsLongTime, IsNull, IsBoolean, Compare {

    private List<Time> oldTime = new ArrayList<>();

    @Autowired
    private Star star;

    @Value("${star.success.number}")
    private int success;

    @Value("${star.fail.number}")
    private int fail;

    @Override
    public boolean isTrueOrFalse(Map<String,Object> o) {
        return false;
    }

    @Override
    public boolean isTimeToLong(Map<String,Object> o) {
        String username=o.get(star.username).toString();
        String time=o.get(star.time).toString();
        log.info(time);
        synchronized (oldTime){
            if (oldTime.size()<=0){
                Time newTime=new Time(username,time);
                log.info("null");
                oldTime.add(newTime);
            }else {
                log.info("not null");
                boolean flag = true;
                for (Time t: oldTime){
                    log.info(t.toString());
                    if (!t.getUsername().equals(username)){
                        continue;
                    }else {
                        flag = false;
                        String newTime=t.getTime();
                        int time1=Integer.parseInt(newTime);
                        int time2=Integer.parseInt(time);
                        if (time1-time2>7200){
                            return true;
                        }
                        t.setTime(time);
                        break;
                    }
                }
                if (flag){
                    Time newTime=new Time(username,time);
                    oldTime.add(newTime);
                }
            }
        }
        return false;
    }

    @Override
    public boolean isNullOrFalse(Map<String,Object> o) {
        if(o ==  null){
            return true;
        }
        if(o.get(star.username).toString() == null){
            return true;
        }
        return false;
    }

    @Override
    public int compareAndEquality(Object o1, Object o2) {

        if (o1 != null && o2 != null){
            if (o1.equals(o2)){
                return success;
            }
        }
        if (o1==null && o2==null){
            return success;
        }
        return fail;
    }
}
