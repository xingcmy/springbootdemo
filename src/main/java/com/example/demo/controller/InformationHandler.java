package com.example.demo.controller;

import com.example.demo.entity.Information;
import com.example.demo.entity.interfaces.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/information")
public class InformationHandler {
    @Autowired
   // private InformationRepository informationRepository;

    @GetMapping("/findAll")
    public List<Information> findAll(){
        return null;//informationRepository.findAll();
    }
}
