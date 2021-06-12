package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface InsertDB {

    @Insert("insert into user values(#{phone},#{password},#{id},#{email},#{head})")
    int insertUser(@Param("phone") String phone,@Param("password") String password,
                   @Param("id") String id,@Param("email") String email,@Param("head") byte[] head);

    @Insert("insert into information values(#{id},#{name},#{signature},#{sex},#{birthday},#{profession},#{city})")
    int insertInformation(@Param("id") String id,@Param("name") String name,@Param("signature") String signature,
                          @Param("sex") String sex,@Param("birthday") String birthday,@Param("profession") String profession,
                          @Param("city") String city);

    @Insert("insert into friends (myid)values(#{id})")
    int inertFriend(@Param("id") String id);

    @Insert("insert into friends (${friend})values(#{id})")
    int inertFriendId(@Param("friend") String friend,@Param("id") String id);
}
