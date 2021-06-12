package com.example.demo.entity.interfaces.repository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.servers")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void findAll(){
        System.out.println(userRepository.findAll());
    }
}