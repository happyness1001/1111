package mxz.controller;

import mxz.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;
import mxz.service.ClientService;
import mxz.service.ManagerService;
import mxz.service.ProviderService;
import mxz.service.StoreService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    //String name, String password, Integer userType,String phone
    public ModelAndView register(HttpServletRequest request, Integer userType){
        ModelAndView modelAndView = new ModelAndView();
        //返回的消息
        String m = "注册失败";
        //注册结果 -1表示用户名重复，0表示注册失败，1表示注册成功
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        //过滤用户名特殊字符
        name = HtmlUtils.htmlEscape(name);
        //注册结果:-1表示用户名已存在,0表示注册失败,1表示注册成功
        Integer result = 0;

        switch (userType){
            case 1:
                result = providerService.register(new Provider(name,password,phone,userType));
                break;
            case 2:
                result = storeService.register(new Store(name,password,phone,userType));
                break;
            case 3:
                result = clientService.register(new Client(name,password,phone,userType));
                break;
            case 4:
                result = managerService.register(new Manager(name,password,userType));
                break;
            default:
                 m = "用户类型无法识别";
                System.out.println(m);
                modelAndView.addObject("msg",m);
                modelAndView.setViewName("forward:/register.jsp");
                return modelAndView;
        }
        switch (result){
            case -1:
                 m = "用户名已存在";
                System.out.println(m);
                modelAndView.setViewName("forward:/register.jsp");
                break;
            case 0:
                System.out.println(m);
                modelAndView.setViewName("forward:/register.jsp");
                break;
            case 1:
                m = "注册成功";
                System.out.println(m);
                modelAndView.setViewName("forward:/login.jsp");
                break;
        }
        modelAndView.addObject("msg",m);
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, Integer userType){
        ModelAndView modelAndView = new ModelAndView();
        //返回的消息
        String m = "登陆失败";
        User result = null;
        String password = request.getParameter("password");
        String name = HtmlUtils.htmlEscape(request.getParameter("name"));
        switch (userType){
            case 1:
                result = providerService.login(new Provider(name,password));
                break;
            case 2:
                result = storeService.login(new Store(name,password));
                break;
            case 3:
                result = clientService.login(new Client(name,password));
                break;
            case 4:
                result = managerService.login(new Manager(name,password));
                break;
            default:
                m = "用户类型无法识别";
                System.out.println(m);
                modelAndView.addObject("msg",m);
                modelAndView.setViewName("forward:/login.jsp");
                return modelAndView;
        }
        if ( null == result ){
            m = "用户名不存在或者密码与用户名不匹配";
            System.out.println(m);
            modelAndView.setViewName("forward:/login.jsp");
        } else if (result.getUserType() == 1) {
            m = "登录成功";
            modelAndView.addObject("user", result);
            modelAndView.setViewName("forward:/providerpage.jsp");
        } else if (result.getUserType() == 4) {
            m = "登录成功";
            modelAndView.addObject("user", result);
            modelAndView.setViewName("forward:/managerpage.jsp");
        } else {
            m = "登录成功";
            modelAndView.addObject("user", result);
            modelAndView.setViewName("forward:/login.jsp");
        }
        modelAndView.addObject("msg",m);
        return modelAndView;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ProviderService getProviderService() {
        return providerService;
    }

    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

    public StoreService getStoreService() {
        return storeService;
    }

    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    public ManagerService getManagerService() {
        return managerService;
    }

    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

}
