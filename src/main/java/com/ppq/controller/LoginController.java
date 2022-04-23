package com.ppq.controller;


import com.ppq.pojo.User;
import com.ppq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password,String isRemPwd, HttpSession session,Model model , HttpServletResponse response) {
        User user = userService.login(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //登录成功
                session.setAttribute("adminUser", user);
                if ("on".equals(isRemPwd)){
                    Cookie cookie1 = new Cookie("loginAdminAct",username);
                    Cookie cookie2 = new Cookie("loginAdminPwd",password);
                    cookie1.setMaxAge(10*24*60*60);
                    cookie2.setMaxAge(10*24*60*60);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }else{
                    //把没有过期cookie删除
                    Cookie c1=new Cookie("loginAdminAct","1");
                    c1.setMaxAge(0);
                    response.addCookie(c1);
                    Cookie c2=new Cookie("loginAdminPwd","1");
                    c2.setMaxAge(0);
                    response.addCookie(c2);
                }
                return "index2";
            } else {
                model.addAttribute("message", "登录失败");
                return "login";
            }
        } else {
            model.addAttribute("message", "你输入的用户名或密码有误");
            return "login";
        }
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        User adminUser = (User) session.getAttribute("adminUser");
        if (adminUser != null) {
            session.removeAttribute("adminUser");
        }
        return "login";
    }
}
