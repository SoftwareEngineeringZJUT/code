package com.app.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WhiteListDao {
    //插入新记录
    @Insert("insert into whitelist values(#{uid},#{gmt_create},#{gmt_update})")
    void InsertUid(Integer uid);

    //查询有无uid
    @Select("select uid from whitelist where uid = #{uid}")
    Integer FindUid(Integer uid);

    //根据uid删除记录
    @Delete("delete from whitelist where uid=#{uid}")
    void DeleteUid(Integer uid);
}
