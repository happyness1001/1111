package mxz.controller;

import mxz.entity.AuditPage;
import mxz.entity.BusinessLicenseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import mxz.service.AuditPageService;
import mxz.service.BusinessLicenseInfoService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
@RequestMapping("/audit")
@Controller
public class AuditController {
    @Autowired
    AuditPageService auditPageService;
    @Autowired
    BusinessLicenseInfoService businessLicenseInfoService;

    public BusinessLicenseInfoService getBusinessLicenseInfoService() {
        return businessLicenseInfoService;
    }

    public void setBusinessLicenseInfoService(BusinessLicenseInfoService businessLicenseInfoService) {
        this.businessLicenseInfoService = businessLicenseInfoService;
    }

    public AuditPageService getAuditPageService() {
        return auditPageService;
    }

    public void setAuditPageService(AuditPageService auditPageService) {
        this.auditPageService = auditPageService;
    }

    //上传审核信息
    @RequestMapping("/addP")
    public ModelAndView addP(BusinessLicenseInfo businessLicenseInfo, AuditPage auditPage){
        int result = 0;
        System.out.println(businessLicenseInfo);
        System.out.println(auditPage);
        result = auditPageService.add(auditPage,businessLicenseInfo);
        if (result == 0){

        }
        return null;
    }

    //审核不同身份商家。1为厂家
    @RequestMapping("/auditUser")
    public ModelAndView auditByUserType(HttpServletRequest request){
        Integer userType = Integer.valueOf(request.getParameter("type"));
        ArrayList<AuditPage> result = auditPageService.auditByUserType(userType);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",result);
        if (userType == 1){
            System.out.println("执行到这里");
            modelAndView.setViewName("forward:/WEB-INF/jsp/audit_page_p.jsp");
        }
        return modelAndView;
    }
    //获取营业执照详细信息
    @RequestMapping("/BLInfo")
    public ModelAndView getBlInfo(HttpServletRequest request){
        BusinessLicenseInfo result = auditPageService.findByBLInfoPageId(request.getParameter("id"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bL",result);
        modelAndView.setViewName("forward:/WEB-INF/jsp/BLInfo.jsp");
        return modelAndView;
    }
    //修改审核单信息
    @RequestMapping("/updateAuditresult")
    public String updateAuditPage(AuditPage auditPage){
        System.out.println(auditPage.getRemark());
        if (auditPageService.update(auditPage) == 1){
            String result = "forward:/audit/auditUser?userType=" + auditPage.getType();
            return result;
        }
        return null;
    }

    //修改营业执照信息
    public void updateBLInfo(AuditPage auditPage){
        //更新营业执照信息
        if(businessLicenseInfoService.update(auditPage.getBusinessLicenseInfo()) == 1){
            //将审核单设置为待审核状态
            auditPage.setState(2);
            auditPageService.update(auditPage);
        };

    }
    //获取某种状态的审核信息
    public void findByPageState(Integer state){
        auditPageService.findByPageState(state);
    }
    //通过用户id获取审核单
    @RequestMapping("/getauditpagebyuid")
    public ModelAndView  findByUid(String uid){
        ArrayList<AuditPage> result = null;
        ModelAndView modelAndView = new ModelAndView();
        result = auditPageService.findByUid(uid);
        System.out.println(uid);
        if(result != null){
            modelAndView.addObject("auditPage",result.get(0));
            modelAndView.setViewName("forward:/WEB-INF/jsp/auditresult.jsp");
        }

        return modelAndView;
    }
}
