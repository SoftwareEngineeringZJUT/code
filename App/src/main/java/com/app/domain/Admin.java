package com.app.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    /**
     *  管理员ID
     */
    @JSONField(ordinal = 1)
    private Integer admin_id;

    /**
     *  账户名
     */
    @JSONField(ordinal = 2)
    private String account;

    /**
     *  密码
     */
    @JSONField(ordinal = 3)
    private String password;

    /**
     *  真实姓名
     */
    @JSONField(ordinal = 4)
    private String real_name;

    /**
     *  权限等级
     */
    @JSONField(ordinal = 5)
    private Integer rank;

    /**
     *  创建时间
     */
    @JSONField(ordinal = 6 , format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date gmt_create;

    /**
     *  更新时间
     */
    @JSONField(ordinal = 7 , format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date gmt_update;

    public Admin(String account, String password, String real_name, Integer rank) {
        this.account = account;
        this.password = password;
        this.real_name = real_name;
        this.rank = rank;
        this.gmt_create = new Date();
        this.gmt_update = new Date();
    }
}
