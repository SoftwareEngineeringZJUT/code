package com.backend.Dao;

import com.backend.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> getAll();
    //获取全部
    @Select("select * from user where account = #{account}")
    User getUserByAccount(String account);
    //根据账户account获取密码
    @Select("select password from user where account = #{account}")
    User getPswdByAccout(String account);
    //根据账户获取uid
    @Select("select uid from user where account = #{account}")
    User getUidByAccout(String account);
    //插入新账户
    @Insert("insert into user(uid,account,password,real_name,id_card,address,bank_card,phone,user_status,balance,label,gmt_create,gmt_update)\n" +
            "values(NULL, #{account}, #{password}, #{real_name}, #{id_card}, #{address}, #{bank_card}, #{phone},#{user_status}, 0, #{label}, 'nFvZ', '', '')")
    void insertUser();

}
