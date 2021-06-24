package com.example.demo.service.servers.serives;

import com.example.demo.dao.InsertDB;
import com.example.demo.service.servers.tools.BooleanTool;
import com.example.demo.service.servers.tools.SendIDTool;
import com.example.demo.service.servers.tools.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface RegisterServer {
   boolean register(Map<String,Object> object);



}
