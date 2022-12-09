package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.dao.AdminDao;
import com.app.domain.Admin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {
    /**
     * 管理员信息删改查
     */

    @Resource
    private AdminDao adminDao;

    @PostMapping("/delAdmin")
    public String delAdmin(Admin _admin){

        String retJSON = "{}";

        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());
        if(admin == null){
            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
            return retJSON;
        }

        adminDao.deleteById(_admin.getAdmin_id());
        retJSON = addKeyValue(retJSON , "status" , "APPROVED");
        return retJSON;
    }


    @PostMapping("/getAdmin")
    public String getAdmin(){
        String retJSON = "[]";

        List<Admin> adminList;
        adminList = adminDao.getAll();

        retJSON = JSON.toJSONString(adminList);

        return retJSON;
    }

    @PostMapping("/updateAdmin")
    public String updateAdmin(Admin _admin){
        String retJSON = "{}";

        Admin admin = adminDao.getAdminById(_admin.getAdmin_id());
        if(admin == null){
            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
            return retJSON;
        }

//        adminDao.up

        return retJSON;
    }
}
