package com.example.demo.entity.interfaces.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InformationRepositoryTest {

    @Autowired
    private InformationRepository informationRepository;
    @Test
    public void findAll(){
        System.out.println(informationRepository.findAll());
    }
}