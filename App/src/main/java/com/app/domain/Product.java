package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    //产品id
    private Integer product_id;

    //产品名称
    private String name;

    //发布者id
    private Integer publisher;

    //商品期限
    private Date expire;

    //年转化率
    private float annual_rate;

    //起存金额
    private double start_deposit;

    //递增金额
    private double increment;

    //每日限购
    private double daily_limit;

    //产品库存
    private double stock;

    //风险等级
    private int risk;

    //结息方式
    private String settlement_type;

    //是否上线.1表示上线
    private int onsale;

    //商品说明
    private String description;

    //原子服务流程
    private String service_process;

    private Date gmt_create;
    private Date gmt_update;

    public Product(String name, Integer publisher, Date expire, float annual_rate, double start_deposit, double increment, double daily_limit, double stock, int risk, String settlement_type, int onsale, String description, String service_process) {
        this.name = name;
        this.publisher = publisher;
        this.expire = expire;
        this.annual_rate = annual_rate;
        this.start_deposit = start_deposit;
        this.increment = increment;
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
