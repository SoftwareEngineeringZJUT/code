package com.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.app.dao.ProductDao;
import com.app.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.app.dao.UserDao;

import java.util.Date;

@SpringBootTest
class AppApplicationTests {

    @Autowired
    private UserDao userDao;
    private User user;
    @Autowired
    private ProductDao productDao;
    @Test
    void contextLoads() {
        user = new User("qwe","qwe","qwe","qwe","qwe","qwe","qwe","qwe",0,"qwe");

        String objectString = JSON.toJSONString(user);

        JSONObject jsonObject = JSON.parseObject(objectString);

        jsonObject.put("valid" , "ok");

        objectString = JSON.toJSONString(jsonObject);

        System.out.println(objectString);

        user.setAccount("???");
        User outuser = userDao.getUserByAccount(user.getAccount());

        System.out.println(outuser);
        System.out.println((outuser == null));

    }

}
