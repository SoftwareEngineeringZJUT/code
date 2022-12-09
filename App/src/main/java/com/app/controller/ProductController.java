package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.dao.AdminDao;
import com.app.dao.ProductDao;
import com.app.domain.Admin;
import com.app.domain.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     *  产品编排(增加)
     *  产品查询
     *      用户
     *      管理员
     *  产品修改
     *  产品删除
     *
     *  产品购买
     *
     *
     */

    @Resource
    private ProductDao productDao;
    @Resource
    private AdminDao adminDao;

    final Integer SUPER_ADMIN = 5;

    @PostMapping("/adminGetProducts")
    public String adminGetProducts(Admin _admin){
        String retJSON = "[]";

        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());
        List<Product> productList ;

        if(admin == null){
            return retJSON;
        }

        System.out.println(admin);

        // 超级管理员
        if(admin.getRank() > SUPER_ADMIN){
            productList = productDao.getAll();
        }
        // 普通管理员
        else{
            productList = productDao.getProductByPublisher(admin.getAdmin_id());
        }

        retJSON = JSON.toJSONString(productList);

        return retJSON;
    }

    @PostMapping("/addProduct")
    public String addProduct(Admin _admin , Product product){
        String retJSON = "{}";
        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());

        if(admin == null){
            retJSON = addKeyValue(retJSON , "status" , "ADMIN_NOT_FOUND");
            return retJSON;
        }



        return retJSON;
    }

    @PostMapping("/userGetProducts")
    public String userGetProducts(){
        String retJSON = "[]";


        return retJSON;
    }
}
