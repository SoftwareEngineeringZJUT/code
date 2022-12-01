package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
     */
    private String gmt_create;

    /**
     * 更新时间
     */
    private String gmt_update;
}
