package mxz.dao;

import mxz.entity.BusinessLicenseInfo;

public interface BusinessLicenseInfoDao {
    Integer add(BusinessLicenseInfo businessLicenseInfo);
    Integer update(BusinessLicenseInfo businessLicenseInfo);
    BusinessLicenseInfo findByAuditPageId(String auditPageId);
    BusinessLicenseInfo findByInfoId(Integer infoId);
    Integer delete(Integer auditPageId);
}
