package com.example.demo.entity.interfaces.repository;

import com.example.demo.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information,String> {
}
