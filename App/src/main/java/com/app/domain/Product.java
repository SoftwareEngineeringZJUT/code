package com.app.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     *  产品id
     */
    @JSONField(ordinal = 1)
    private Integer product_id;

    /**
     *  产品名称
     */
    @JSONField(ordinal = 2)
    private String name;

    /**
     *  发布者id
     */
    @JSONField(ordinal = 3)
    private Integer publisher;

    /**
     *  商品期限
     */
    @JSONField(ordinal = 4)
    private Date expire;

    /**
     *  年转化率
     */
    @JSONField(ordinal = 5)
    private float annual_rate;

    /**
     *  起存金额
     */
    @JSONField(ordinal = 6)
    private double start_deposit;

    /**
     *  递增金额
     */
    @JSONField(ordinal = 7)
    private double increment;

    /**
     *  每人限额
     */
    @JSONField(ordinal = 8)
    private double personal_limit;

    /**
     *  每日限购
     */
    @JSONField(ordinal = 9)
    private double daily_limit;

    /**
     *  产品库存
     */
    @JSONField(ordinal = 10)
    private double stock;

    /**
     *  风险等级
     */
    @JSONField(ordinal = 11)
    private int risk;

    /**
     *  结息方式
     */
    @JSONField(ordinal = 12)
    private String settlement_type;

    /**
     *  是否上线.1表示上线
     */
    @JSONField(ordinal = 13)
    private int onsale;

    /**
     *  商品说明
     */
    @JSONField(ordinal = 14)
    private String description;

    /**
     * 原子服务流程
     */
    @JSONField(ordinal = 15)
    private String service_process;

    /**
     * 创建时间
     */
    @JSONField(ordinal = 16 , format="yyyy-MM-dd")
    private Date gmt_create;

    /**
     * 更新时间
     */
    @JSONField(ordinal = 17 , format="yyyy-MM-dd")
    private Date gmt_update;

    public Product(String name, Integer publisher, Date expire, float annual_rate, double start_deposit, double increment,double personal_limit, double daily_limit, double stock, int risk, String settlement_type, int onsale, String description, String service_process) {
        this.name = name;
        this.publisher = publisher;
        this.expire = expire;
        this.annual_rate = annual_rate;
        this.start_deposit = start_deposit;
        this.increment = increment;
        this.personal_limit = personal_limit;
        this.daily_limit = daily_limit;
        this.stock = stock;
        this.risk = risk;
        this.settlement_type = settlement_type;
        this.onsale = onsale;
        this.description = description;
        this.service_process = service_process;
        this.gmt_create = new Date();
        this.gmt_update = new Date();
    }
}
