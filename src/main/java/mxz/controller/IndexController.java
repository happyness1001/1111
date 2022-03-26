package mxz.controller;

import mxz.entity.*;
import mxz.service.ClientService;
import mxz.service.ManagerService;
import mxz.service.ProviderService;
import mxz.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ProviderService providerService;

    //访问首页
    @RequestMapping("/")
    public String indexDo(HttpServletRequest request, HttpSession session) {
        String username = null;
        String password = null;
        String userType = null;
        Cookie[] cookies = request.getCookies();
        User result = null;
        String m = "注册失败";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("username".equals(name)) {
                    username = cookie.getValue();
                } else if ("password".equals(name)) {
                    password = cookie.getValue();
                } else if ("userType".equals(name)) {
                    userType = cookie.getValue();
                }
            }

        }
        //如果cookie缓存的用户名、密码、用户类型不为空,进行自动登录操作
        if (username != null && password != null && userType != null) {
            switch (userType) {
                case "1":
                    result = providerService.login(new Provider(username, password));
                    break;
                case "2":
                    result = storeService.login(new Store(username, password));
                    break;
                case "3":
                    result = clientService.login(new Client(username, password));
                    break;
                case "4":
                    result = managerService.login(new Manager(username, password));
                    break;
                default:
                    m = "用户类型无法识别";
                    System.out.println(m);
                    return "forward:/login.jsp";
            }
            //处理验证后结果
            if (null == result) {
                return "index";
            } else {
                session.setAttribute("username", username);
                session.setAttribute("uid", result.getUid());
                if (result.getUserType() == 1) {
                    return "forward:/providerpage.jsp";
                } else if (result.getUserType() == 2) {
                    m = "登录成功";
                } else if (result.getUserType() == 4) {
                    m = "登录成功";
                    return "forward:/managerpage.jsp";
                } else {
                    return "forward:/login.jsp";
                }
            }
        }
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "user/login";
    }
}
