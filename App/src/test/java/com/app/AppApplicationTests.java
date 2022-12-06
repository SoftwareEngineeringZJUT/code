package com.app;

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
        userDao.insertUser(user);
        System.out.println(userDao.getUserByUid(21));
        System.out.println(productDao);
    }

}
