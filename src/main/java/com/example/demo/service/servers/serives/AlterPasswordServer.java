package com.example.demo.service.servers.serives;

import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public interface AlterPasswordServer {
    boolean alterPassword(Map<String,Object> object);
}
