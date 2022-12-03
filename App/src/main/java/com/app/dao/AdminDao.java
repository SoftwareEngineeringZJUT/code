package com.app.dao;

import com.app.domain.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminDao {
    //获取全部admin
    @Select("select * from admin")
    List<Admin> getAll();

    //插入新的admin
    @Insert("insert into admin(admin_id,account,password,real_name,rank,gmt_create,gmt_update) values(NULL,#{account},#{password},#{real_name},#{rank}.#{gmt_create},#{gmt_update});")
    void insertAdmin(Admin admin);

    //根据账户account获取密码password
    @Select("select password from admin where account=#{account}")
    String getPswdByAccount(String account);

    //根据账户account获取admin_id
    @Select("select admin_id from admin where account=#{account}")
    Integer getIdByAccount(String account);

    //根据uid修改密码
    @Update("update admin set password=#{password} where admin_id=#{admin_id}")
    void updatePswdByUid(Integer uid);

    //根据uid修改真实姓名
    @Update("update admin set real_name=#{real_name} where admin_id=#{admin_id}")
    void updateRealnameByUid(Integer uid,String real_name);

    //根据uid修改权限rank
    @Update("update admin set `rank`=#{rank} where admin_id=#{admin_id}")
    void updateRankByUid(Integer uid,String rank);

    //根据uid删除一条记录
    @Delete("delete from admin where admin_id=#{admin_id}")
    void deleteById(Integer admin_id);

}
