package com.app.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlackListDao {
    //插入新记录
    @Insert("insert into blacklist values(#{uid})")
    void InsertUid(Integer uid);

    //根据uid删除记录
    @Delete("delete from blacklist where uid=#{uid}")
    void DeleteUid(Integer uid);
}
