package com.app.controller;

import com.app.dao.AdminDao;
import com.app.dao.UserDao;
import com.app.domain.Admin;
import com.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/signIn")
public class SignInController {

    @Resource
    private UserDao userDao;
    @Resource
    private AdminDao adminDao;

    @PostMapping("/userSignIn")
    public String userSignIn(User _user){

        String retJSON = "{}";

        // 验证账号
        String account = _user.getAccount();

        // 验证银行卡号
        String bank_card = _user.getBank_card();

        // todo 添加bank_card_list表



        return retJSON;
    }

    @PostMapping("/adminSignIn")
    public String adminSignIn(Admin _admin){
        String retJSON = "{}";

        System.out.println(_admin);
        String account = _admin.getAccount();

        Admin admin = adminDao.getAdminByAccount(account);

        if(admin == null){
            retJSON = addKeyValue(retJSON , "status" , "APPROVED");
//            adminDao.insertAdmin(_admin);
        }   else{
            retJSON = addKeyValue(retJSON , "status" , "ACCOUNT_DUPLICATED");
        }
        System.out.println(retJSON);
        return retJSON;
    }
}