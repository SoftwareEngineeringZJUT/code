package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserDao userDao;
    @Resource
    private  AdminDao adminDao;

    @PostMapping("/roleLogin")
    public String roleLogin(String account , String password){

        String retJSON = "{}";

        Admin admin = adminDao.getAdminByAccount(account);
        User user = userDao.getUserByAccount(account);

       if(admin == null && user == null){
           retJSON = addKeyValue(retJSON , "status" , "NOT_FOUND");
           return retJSON;
       }

       else if(admin != null){

           if(admin.getPassword().equals(password)){
               retJSON = JSON.toJSONString(admin);
               retJSON = addKeyValue(retJSON , "status" , "APPROVED");
               retJSON = addKeyValue(retJSON , "role" , "admin");
           }
           else {
               retJSON = addKeyValue(retJSON , "status" , "INFO_ERR");
           }
       }

       else{
           if(user.getPassword().equals(password)){
               retJSON = JSON.toJSONString(user);
               retJSON = addKeyValue(retJSON , "status" , "APPROVED");
               retJSON = addKeyValue(retJSON , "role" , "user");
           }
           else {
               retJSON = addKeyValue(retJSON , "status" , "INFO_ERR");
           }
       }
       return retJSON;
    }

    /**
     * @param _user 用户
     * @return jsonOutput
     */

    @PostMapping("/userLogin")
    public String userLogin(User _user){

        String jsonOutput = "{}";
        User user = userDao.getUserByAccount(_user.getAccount());

        // 用户不存在
        if(user == null){
            jsonOutput = addKeyValue(jsonOutput , "status" , "NOT_FOUND");
            return jsonOutput;
        }

        // 信息正确
        if(user.getAccount().equals(_user.getAccount()) &&
           user.getPassword().equals(_user.getPassword()) ){
            jsonOutput = JSON.toJSONString(user , SerializerFeature.WriteMapNullValue);
            jsonOutput = addKeyValue(jsonOutput , "status" , "APPROVED");
            return jsonOutput;

        }
        // 信息错误
        else{
            jsonOutput = addKeyValue(jsonOutput , "status" , "INFO_ERR");
            return jsonOutput;
        }
    }

    /**
     * @param _admin
     * @return jsonOutput
     */
    @ResponseBody
    @PostMapping("/adminLogin")
    public String adminLogin(Admin _admin){
        String jsonOutput = "{}";
        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());

        // 用户不存在
        if(admin == null){
            jsonOutput = addKeyValue(jsonOutput , "status" , "NOT_FOUND");
            return jsonOutput;
        }

        // 信息正确
        if(admin.getAccount().equals(_admin.getAccount()) &&
                admin.getPassword().equals(_admin.getPassword()) ){
            jsonOutput = JSON.toJSONString(admin , SerializerFeature.WriteMapNullValue);
            jsonOutput = addKeyValue(jsonOutput , "status" , "APPROVED");
            return jsonOutput;

        }
        // 信息错误
        else{
            jsonOutput = addKeyValue(jsonOutput , "status" , "INFO_ERR");
            return jsonOutput;
        }
    }


}
