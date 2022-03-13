package mxz.service;

import mxz.entity.BusinessLicenseInfo;


public interface BusinessLicenseInfoService {
    Integer add(BusinessLicenseInfo businessLicenseInfo);
    Integer update(BusinessLicenseInfo businessLicenseInfo);
    BusinessLicenseInfo findByAuditPageId(String auditPageId);
    BusinessLicenseInfo findByInfoId(Integer infoId);
    Integer delete(Integer auditPageId);
}
