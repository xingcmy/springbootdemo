package com.example.demo.service.servers.serives;

import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public interface LoginServer {
    boolean logIn(Map<String,Object> object);
}
