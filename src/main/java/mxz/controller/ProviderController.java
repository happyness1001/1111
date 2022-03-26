package mxz.controller;

import mxz.entity.AuditPage;
import mxz.entity.BusinessLicenseInfo;
import mxz.service.AuditPageService;
import mxz.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;
    @Autowired
    private AuditPageService auditPageService;

    @RequestMapping("/register")
    public ModelAndView pregister(BusinessLicenseInfo businessLicenseInfo, AuditPage auditPage) {
        int result = 0;
        System.out.println(businessLicenseInfo);
        System.out.println(auditPage);
        result = auditPageService.add(auditPage, businessLicenseInfo);
        if (result == 0) {

        }
        return null;
    }
}
