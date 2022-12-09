package com.app.dao;

import com.app.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderDao {
    //插入一条新记录
    @Insert("insert into `order`(id,priduct_id,user_id,amount,state,pay_time,gmt_create,gmt_update)" +
        "values(NULL,#{priduct_id},#{user_id},#{amount},#{state},#{pay_time},#{gmt_create},#{gmt_update})")
    void InsertOrder(Order order);

    //获取全部订单信息
    @Select("select * from `order`")
    List<Order> GetAllOrder();

    //根据产品id查询订单信息
    @Select("select * from `order` where product_id=#{product_id}")
    List<Order> GetByProductId(Integer product_id);

    //根据用户id查询订单信息
    @Select("select * from `order` where user_id=#{user_id}")
    List<Order> GetByUserId(Integer user_id);

    //根据订单编号查询订单信息
    @Select("select * from `order` where id=#{id}")
    Order GetById(Integer id);

    //根据用户id修改订单支付状态、支付时间
    @Update("update `order` set `state`=#{state},pay_time=#{pay_time} where user_id=#{user_id}")
    void UpdatePayStateAndTimeByUserId(Integer user_id, String state, Date pay_time);

    //根据订单编号修改订单支付状态、支付时间
    @Update("update `order` set `state`=#{state},pay_time=#{pay_time} where id=#{id}")
    void UpdateStateAndTimeById(Integer id , String state , Date pay_time);

    //根据订单编号删除记录
    @Delete("delete from `order` where id=#{id}")
    void DeleteById(Integer id);
}
