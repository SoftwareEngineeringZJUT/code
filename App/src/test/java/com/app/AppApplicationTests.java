package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.app.dao.UserDao;
@SpringBootTest
class AppApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao.getUserByAccount("夏明辉"));
    }

}
