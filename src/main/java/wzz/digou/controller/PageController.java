package wzz.digou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class PageController {
    @RequestMapping("registerPage")
    public String registerPage() {
        return "2cjsp/fore/register";
    }

    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "2cjsp/fore/registerSuccess";
    }


//    @RequestMapping("admin_product_listAll")
//    public String admin_product_listAll(){
//        return "admin/listProduct";
//    }


    @RequestMapping("loginPage")
    public String loginPage() {
        return "2cjsp/fore/login";
    }
//    @RequestMapping("forealipay")
//    public String alipay(){
//        return "fore/alipay";
//    }

    //我自己添加的
    @RequestMapping("adminloginPage")
    public String foreadminlogin() {
        System.out.println("**********");

        return "2cjsp/admin/admin_login";
    }

    //    云小蜜客服API调用
    @RequestMapping("keFuPage")
    public String keFuPage(HttpSession session) {

        return "2cjsp/fore/custom";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "2cjsp/admin/admin_index";
    }

}

