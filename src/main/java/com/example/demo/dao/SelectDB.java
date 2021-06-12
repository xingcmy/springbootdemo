package com.example.demo.dao;

import com.example.demo.dao.friend.Friends;
import com.example.demo.dao.information.Information;
import com.example.demo.dao.user.AllUserId;
import com.example.demo.dao.user.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface SelectDB {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> selectUserAll();

    @Select("select id from user")
    List<AllUserId> selectAllUserId();

    @Select("select * from user where id=#{id}")
    User selectUser(@Param("id") String id);

    /**
     * 根据账号查询用户头像
     * @param id
     * @return
     */
    @Select("select head from user where id=#{id}")
    Object selectUserHead(@Param("id") String id);

    @Select("select phone from user where id=#{id}")
    String selectUserPhone(@Param("id") String id);

    @Select("select id from user where ${id}=#{username}")
    String selectUserId(@Param("id") String id,@Param("username") String username);

    @Select("select password from user where id=#{id}")
    String selectUserPassword(@Param("id") String id);

    @Select("select email from user where id=#{id}")
    String selectUserEmail(@Param("id") String id);

    @Select("select ${name} from user where id=#{id}")
    Object selectUserDB(@Param("name") String name,@Param("id") String id);

    @Select("select myid as id,${name} as friend from friends where myid=#{id}")
    Friends selectFriend(@Param("name") String name,@Param("id") String id);

    @Select("select * from information")
    List<Information> selectInformationAll();

    @Select("select * from information where id=#{id}")
    Information selectInformation(@Param("id") String id);

    @Select("select name from information where id=#{id}")
    String selectInformationName(@Param("id") String id);

    @Select("select signature from information where id=#{id}")
    String selectInformationSignature(@Param("id") String id);

    @Select("select sex from information where id=#{id}")
    String selectInformationSex(@Param("id") String id);

    @Select("select birthday from information where id=#{id}")
    String selectInformationBirthday(@Param("id") String id);

    @Select("select profession from information where id=#{id}")
    String selectInformationProfession(@Param("id") String id);

    @Select("select city from information where id=#{id}")
    String selectInformationCity(@Param("id") String id);

    @Select("select ${name} from information where id=#{id}")
    Object selectInformationDB(@Param("name") String name,@Param("id") String id);
}
