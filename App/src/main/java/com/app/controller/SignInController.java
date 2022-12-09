package com.app.controller;

import com.app.dao.AdminDao;
import com.app.dao.BankDao;
import com.app.dao.UserDao;
import com.app.domain.Admin;
import com.app.domain.Bank;
import com.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Date;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/signIn")
public class SignInController {

    @Resource
    private UserDao userDao;
    @Resource
    private AdminDao adminDao;
    @Resource
    private BankDao bankDao;

    @PostMapping("/userSignIn")
    public String userSignIn(User _user){

        String retJSON = "{}";

        // 验证账号
        String account = _user.getAccount();
        User user = userDao.getUserByAccount(_user.getAccount());
        if(user != null){
            retJSON = addKeyValue(retJSON , "status" , "ACCOUNT_DUPLICATED");
            return retJSON;
        }

        // 验证银行卡号
        String bank_card = _user.getBank_card();
        Bank bank = bankDao.getBankByBankCard(bank_card);
        if(bank == null){
            retJSON = addKeyValue(retJSON , "status" , "BANK_CARD_NOT_FOUND");
            return retJSON;
        }

        _user.setBalance(0);
        _user.setLabel("");
        _user.setGmt_create(new Date());
        _user.setGmt_update(new Date());
        _user.setUser_status("0");

        System.out.println(_user);

        userDao.insertUser(_user);

        retJSON = addKeyValue(retJSON , "status" , "APPROVED");
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