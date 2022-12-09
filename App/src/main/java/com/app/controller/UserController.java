package com.app.controller;

import com.app.dao.ProductDao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private ProductDao productDao;

    @PostMapping("/getProducts")
    public String getProducts(){
        String retJSON = "[]";


        return retJSON;
    }
}
