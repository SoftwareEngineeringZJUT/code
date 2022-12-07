package com.app.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     *  订单编号
     */
    @JSONField(ordinal = 1)
    private Integer id;

    /**
     *  产品id
     */
    @JSONField(ordinal = 2)
    private Integer priduct_id;

    /**
     *  用户id
     */
    @JSONField(ordinal = 3)
    private Integer user_id;

    /**
     *  余额
     */
    @JSONField(ordinal = 4)
    private double amount;

    /**
     *  支付状态,0表示未支付，1表示已支付，2表示已取消
     */
    @JSONField(ordinal = 5)
    private int state;

    /**
     *  支付时间
     */
    @JSONField(ordinal = 6 , format="yyyy-MM-dd")
    private Date pay_time;

    /**
     * 创建时间
     */
    @JSONField(ordinal = 7 , format="yyyy-MM-dd")
    private Date gmt_create;

    /**
     * 更新时间
     */
    @JSONField(ordinal = 8 , format="yyyy-MM-dd")
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
