package com.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.dao.ProductDao;
import com.app.domain.Product;
import com.app.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.app.dao.UserDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class AppApplicationTests {

    @Autowired
    private ProductDao productDao;
    @Test
    void contextLoads() {
        Product product = new Product();
        Product productById = productDao.getProductById(2001);
        System.out.println(productById.getExpire().getClass());
        System.out.println(productById.getExpire());
//        List<Product> productArrayList = new ArrayList<>();
//        productArrayList = productDao.getProductByPublisher(2);
//
//        System.out.println(productArrayList);
    }

}
