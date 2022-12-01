package com.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer admin_id;
    private String account;
    private String password;
    private String real_name;
    private Integer rank;
    private String gmt_create;
    private String gmt_update;
}
