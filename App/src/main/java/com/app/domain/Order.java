package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    //订单编号
    private Integer id;

    //产品id
    private Integer priduct_id;

    //用户id
    private Integer user_id;

    //余额
    private double amount;

    //支付状态,0表示未支付，1表示已支付，2表示已取消
    private int state;

    //支付时间
    private Date pay_time;

    private Date gmt_create;
    private Date gmt_update;

    public Order(Integer priduct_id, Integer user_id, double amount, int state, Date pay_time) {
        this.priduct_id = priduct_id;
        this.user_id = user_id;
        this.amount = amount;
        this.state = state;
        this.pay_time = pay_time;
        this.gmt_create = new Date();
        this.gmt_update = new Date();
    }
}
