package com.app.dao;

import com.app.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    // 获取全部
    @Select("select * from user")
    List<User> getAll();

    // 根据账户account获取用户
    @Select("select * from user where account = #{account}")
    User getUserByAccount(String account);

    // 根据uid获取用户
    @Select("select * from user where uid = #{uid}")
    User getUserByUid(Integer  uid);

    // 根据账户获取密码
    @Select("select password from user where account = #{account}")
    User getPswdByAccout(String account);

    // 根据账户获取uid
    @Select("select uid from user where account = #{account}")
    User getUidByAccout(String account);

    // 插入新账户
    @Insert("insert into user(uid,account,password,real_name,id_card,address,bank_card,phone,user_status,balance,label)\n" +
            "values(NULL, #{account}, #{password}, #{real_name}, #{id_card}, #{address}, #{bank_card}, #{phone},#{user_status}, 0, #{label})")
    void insertUser(User user);

    //根据用户的uid修改一个用户（user）的密码
    @Update("update user set password=#{password} where uid=#{uid}")
    void updatePswdByUid(Integer uid,String password);

    //根据用户的uid修改一个用户的基本信息（真实姓名、身份证号、住址区域、银行卡、电话、用户状态）
    @Update("update user set real_name=#{real_name} ,id_card=#{id_card},address=#{address},bank_card=#{bank_card},phone=#{phone},user_status=#{user_status} where uid=#{uid};")
    void updateInfo(Integer uid,String real_name,String id_card,String address,String bank_card,String phone,String user_status);

    //根据用户的uid修改一个用户的用户标签
    @Update("update user set label=#{label} where uid=#{uid}")
    void updateLabelByUid(Integer uid,String label);

    //根据用户的uid修改一个用户的余额
    @Update("update user set balance=#{balance} where uid=#{uid};")
    void updateBalanceByUid(Integer uid,String balance);

    //根据用户的uid删除一个用户
    @Delete("delete from user where uid=#{uid};")
    void deleteByUid(Integer uid);
}
