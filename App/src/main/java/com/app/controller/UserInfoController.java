package com.app.controller;

import com.app.dao.UserDao;
import com.app.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.app.core.util.MyJSONUtil.addKeyValue;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    /**
     * 用户信息删改查
     */
    @Resource
    private UserDao userDao;
    /**
     * 用户删除
     * @param
     * @return
     */
    @PostMapping("/userDelete")
    public String userDelete(User _user)
    {
        String retJSON = "{}";
        User user = userDao.getUserByAccount(_user.getAccount());

        //用户不存在
        if(user == null)
        {
            retJSON = addKeyValue(retJSON,"status","USER_NOT_FOUND");
            return retJSON;
        }

        //用户存在
        else {
            userDao.deleteByUid(user.getUid());
            retJSON = addKeyValue(retJSON,"status","SUCCESS");
            return retJSON;
        }
    }
}
