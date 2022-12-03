package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * uid 用户标识符
     */
    private Integer uid;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String real_name;

    /**
     *  身份证号
     */
    private String id_card;

    /**
     * 所属区域
     */
    private String address;

    /**
     * 银行卡号
     */
    private String bank_card;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户状态
     */
    private String user_status;

    /**
     * 余额
     */
    private Integer balance;

    /**
     * 用户标签
     */
    private String label;

    /**
     * 创建时间
     * 构造的时候传入一个new Date()即可
     */
    private Date gmt_create;

    /**
     * 更新时间
     */
    private Date gmt_update ;

    public User(String account, String password, String real_name, String id_card, String address, String bank_card, String phone, String user_status, Integer balance, String label) {
        this.account = account;
        this.password = password;
        this.real_name = real_name;
        this.id_card = id_card;
        this.address = address;
        this.bank_card = bank_card;
        this.phone = phone;
        this.user_status = user_status;
        this.balance = balance;
        this.label = label;
        this.gmt_create = new Date();
        this.gmt_update = new Date();
    }
}
