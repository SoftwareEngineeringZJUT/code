package com.app.controller;

import com.app.core.util.Result;
import com.app.core.util.ResultUtil;
import com.app.dao.UserDao;
import com.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserDao userDao;


    /**
     *
     * @param _user 用户
     * @param request
     * @return
     * @throws Exception
     */

    @ResponseBody
    @PostMapping
    public Result<User> userLogin(User _user , HttpServletRequest request) throws Exception{
        User user = userDao.getUserByAccount(_user.getAccount());

        if(user.getAccount().equals(_user.getAccount()) &&
           user.getPassword().equals(_user.getPassword()) ){

            request.getSession().setAttribute("real_name" , user.getReal_name());

            return ResultUtil.SUCCESS();
        } else{
          return ResultUtil.Error400("用户名或密码错误");
        }
    }
}
