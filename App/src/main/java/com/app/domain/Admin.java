package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer admin_id;
    private String account;
    private String password;
    private String real_name;
    private Integer rank;
    private Date gmt_create;
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
