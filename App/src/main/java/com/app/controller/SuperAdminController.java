package com.app.controller;

import com.app.dao.AdminDao;
import com.app.dao.BankDao;
import com.app.dao.UserDao;
import com.app.domain.Admin;
import com.app.domain.Bank;
import com.app.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/superAdmin")
public class SuperAdminController {


    /**
     *  管理员信息更新
     *      增加 ok
     *      删除
     *      查询
     *      更改
     *  用户信息更新
     *      增加 ok
     *      删除
     *      查询
     *      更改
     */


}
