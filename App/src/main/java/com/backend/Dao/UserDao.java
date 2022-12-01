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
    List<User> getAll();//获取全部
    @Select("select * from user where account = #{account}")
    User getUserByAccount(String account);//根据账户account获取用户
    @Select("select select * from user where uid = #{uid}")
    User getUserByUid(String uid);//根据账户account获取用户
    @Select("select password from user where account = #{account}")
    User getPswdByAccout(String account);//根据账户获取密码
    @Select("select uid from user where account = #{account}")
    User getUidByAccout(String account);//根据账户获取uid
    @Insert("insert into user(uid,account,password,real_name,id_card,address,bank_card,phone,user_status,balance,label)\n" +
            "values(NULL, #{account}, #{password}, #{real_name}, #{id_card}, #{address}, #{bank_card}, #{phone},#{user_status}, 0, #{label})")
    void insertUser(User user);//插入新账户

}
