package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public interface UpdateDB {

    /**
     * 修改用户密码 password
     * @param password
     * @param id
     * @return
     */
    @Update("update user set password=#{password} where id=#{id}")
    int updateUserPassword(@Param("password") String password,@Param("id") String id);

    /**
     * 修改用户手机号 phone
     * @param phone
     * @param id
     * @return
     */
    @Update("update user set phone=#{phone} where id=#{id}")
    int updateUserPhone(@Param("phone") String phone,@Param("id") String id);

    /**
     * 修改用户头像 head
     * @param head
     * @param id
     * @return
     */
    @Update("update user set head=#{head} where id=#{id}")
    int updateUserHead(@Param("head") String head,@Param("id") String id);

    /**
     * 修改用户邮箱 email
     * @param email
     * @param id
     * @return
     */
    @Update("update user set email=#{email} where id=#{id}")
    int updateUserEmail(@Param("email") String email,@Param("id") String id);

    /**
     * 修改用户信息
     * @param name 数据库列名
     * @param user
     * @param id
     * @return
     */
    @Update("update user set ${name}=#{user} where id=#{id}")
    int updateUser(@Param("name") String name,@Param("user") String user,@Param("id") String id);

    /**
     * 修改用户信息
     * @param phone
     * @param password
     * @param email
     * @param id
     * @return
     */
    @Update("update user set phone=#{phone},password=#{password},email=#{email} where id=#{id}")
    int updateUserPPE(@Param("phone") String phone,@Param("password") String password,@Param("email") String email,
                   @Param("id") String id);

    /**
     * 修改好友列表 好友账号
     * @param name
     * @param friend
     * @param id
     * @return
     */
    @Update("update friends set ${name}=#{friend} where myid=#{id}")
    int updateFriend(@Param("name") String name,@Param("friend") String friend,@Param("id") String id);

    /**
     * 修改用户基本信息
     * @param name
     * @param signature
     * @param sex
     * @param birthday
     * @param profession
     * @param city
     * @param id
     * @return
     */
    @Update("update information set name=#{name},signature=#{signature},sex=#{sex}," +
            "birthday=#{birthday},profession=#{profession},city=#{city} where id=#{id}")
    int updateInformationAll(@Param("name") String name,@Param("signature") String signature,@Param("sex") String sex,
                          @Param("birthday") String birthday,@Param("profession") String profession,@Param("city") String city,
                          @Param("id") String id);

    /**
     * 单个修改用户基本信息
     * @param name
     * @param information
     * @param id
     * @return
     */
    @Update("update information set ${name}=#{information} where id=#{id}")
    int updateInformation(@Param("name") String name,@Param("information") String information,@Param("id") String id);
}
