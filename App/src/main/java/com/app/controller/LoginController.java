package com.app.controller;

import com.app.core.util.Result;
import com.app.core.util.ResultUtil;
import com.app.dao.AdminDao;
import com.app.dao.UserDao;
import com.app.domain.Admin;
import com.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserDao userDao;
    @Resource
    private  AdminDao adminDao;

    /**
     *
     * @param _user 用户
     * @param request
     * @return
     * @throws Exception
     */

//    @ResponseBody
    @PostMapping("/userLogin")
    public String userLogin(User _user , HttpServletRequest request , Model model) throws Exception{
        User user = userDao.getUserByAccount(_user.getAccount());

        if(user == null) return "index";

        System.out.println(user);

        if(user.getAccount().equals(_user.getAccount()) &&
           user.getPassword().equals(_user.getPassword()) ){

            request.getSession().setAttribute("identity" , "user");
            request.getSession().setAttribute("user" , user);

            model.addAttribute("account" , "testss");
            model.addAttribute("password" , "testssssx");

            System.out.println("ok");

            return "index";
        } else{


            return "index";
        }
    }

    @PostMapping("/adminLogin")
    public String adminLogin(Admin _admin , HttpServletRequest request , Model model) throws Exception{
        Admin admin = adminDao.getAdminByAccount(_admin.getAccount());

        if(admin == null) return "index";

        if(admin.getAccount().equals(_admin.getAccount()) &&
                admin.getPassword().equals(_admin.getPassword()) ){

            request.getSession().setAttribute("identity" , "admin");
            request.getSession().setAttribute("user" , admin);

            return "index";
        } else{
            return "index";
        }
    }


}
