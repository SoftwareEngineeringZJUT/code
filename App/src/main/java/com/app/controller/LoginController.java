package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.app.dao.AdminDao;
import com.app.dao.UserDao;
import com.app.domain.Admin;
import com.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserDao userDao;
    @Resource
    private  AdminDao adminDao;

    /**
     *
     * @param _user 用户
     * @return jsonOutput
     */

    @ResponseBody
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
     *
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
