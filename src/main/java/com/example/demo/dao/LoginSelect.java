package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface LoginSelect {

    @Select("select password from user where phone=#{phone}")
    String phoneLogin(@Param("phone") String phone);

    @Select("select password from user where email=#{email}")
    String emailLogin(@Param("email") String email);

    @Select("select password from user where id=#{id}")
    String idLogin(@Param("id") String id);
}
