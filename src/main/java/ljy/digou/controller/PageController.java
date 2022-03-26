package ljy.digou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("registerPage")
    public String registerPage() {
        return "jsp/fore/register";
    }

    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "jsp/fore/registerSuccess";
    }

    @RequestMapping("loginPage")
    public String loginPage() {
        return "jsp/fore/login";
    }
//    @RequestMapping("forealipay")
//    public String alipay(){
//        return "fore/alipay";
//    }

    //我自己添加的
    @RequestMapping("adminloginPage")
    public String foreadminlogin() {
        System.out.println("**********");

        return "jsp/admin/admin_login";
    }

    //    云小蜜客服API调用
    @RequestMapping("keFuPage")
    public String keFuPage(HttpSession session) {

        return "jsp/fore/custom";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "jsp/admin/admin_index";
    }

}

