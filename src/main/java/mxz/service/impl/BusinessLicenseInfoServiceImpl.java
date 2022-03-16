package mxz.service.impl;

import mxz.dao.BusinessLicenseInfoDao;
import mxz.entity.BusinessLicenseInfo;
import mxz.service.BusinessLicenseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class BusinessLicenseInfoServiceImpl implements BusinessLicenseInfoService {
    @Autowired
    BusinessLicenseInfoDao businessLicenseInfoDao;

    public BusinessLicenseInfoDao getBusinessLicenseInfoDao() {
        return businessLicenseInfoDao;
    }

    public void setBusinessLicenseInfoDao(BusinessLicenseInfoDao businessLicenseInfoDao) {
        this.businessLicenseInfoDao = businessLicenseInfoDao;
    }

    @Override
    public Integer add(BusinessLicenseInfo businessLicenseInfo) {
        businessLicenseInfo.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        return businessLicenseInfoDao.add(businessLicenseInfo);
    }

    @Override
    public Integer update(BusinessLicenseInfo businessLicenseInfo) {
        businessLicenseInfo.setUpdateDateTime(new Timestamp(System.currentTimeMillis()));
        return businessLicenseInfoDao.update(businessLicenseInfo);
    }

    @Override
    public BusinessLicenseInfo findByAuditPageId(String auditPageId) {
        return businessLicenseInfoDao.findByAuditPageId(auditPageId);
    }

    @Override
    public BusinessLicenseInfo findByInfoId(Integer infoId) {
        return businessLicenseInfoDao.findByInfoId(infoId);
    }

    @Override
    public Integer delete(Integer auditPageId) {
        return businessLicenseInfoDao.delete(auditPageId);
    }
}
