package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logOut")
public class LogOutController {

    @ResponseBody
    @GetMapping("/userLogOut")
    public String userLogOut(HttpServletRequest request) throws Exception {

        request.getSession().removeAttribute("identity");
        request.getSession().removeAttribute("user");

        return "login";
    }

    @GetMapping("/adminLogOut")
    public String adminLogOut(HttpServletRequest request) throws Exception {

        request.getSession().removeAttribute("identity");
        request.getSession().removeAttribute("admin");

        return "login";
    }


}
