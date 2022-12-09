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

    @Resource
    private AdminDao adminDao;

    /**
     * 删除管理员
     * @param _admin
     * @return
     */
    @PostMapping("/delAdmin")
    public String delAdmin(Admin _admin){

        String retJSON = "{}";

        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());
        if(admin == null){
            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
            return retJSON;
        }
        adminDao.deleteById(admin.getAdmin_id());
        retJSON = addKeyValue(retJSON , "status" , "APPROVED");
        return retJSON;
    }

    /**
     * 获取所有管理员
     * @return
     */
    @PostMapping("/getAdmin")
    public String getAdmin(){
        String retJSON = "[]";

        List<Admin> adminList;
        adminList = adminDao.getAll();

        retJSON = JSON.toJSONString(adminList);

        return retJSON;
    }

    /**
     * 更新管理员信息
     * @param _admin
     * @return
     */
    @PostMapping("/updateAdmin")
    public String updateAdmin(Admin _admin){
        String retJSON = "{}";

        // 存在性检验
        Admin admin = adminDao.getAdminById(_admin.getAdmin_id());
        if(admin == null){
            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
            return retJSON;
        }

        // 更新账户信息
        String newaccount = _admin.getAccount();
        admin = adminDao.getAdminByAccount(newaccount);
        if(admin != null && admin.getAdmin_id() != _admin.getAdmin_id()){
            retJSON = addKeyValue(retJSON , "status" , "ACCOUNT_DUPLICATED");
            return retJSON;
        }

        adminDao.updateAdmin(_admin);
        retJSON = addKeyValue(retJSON , "status" , "APPROVED");
        return retJSON;
    }
}
