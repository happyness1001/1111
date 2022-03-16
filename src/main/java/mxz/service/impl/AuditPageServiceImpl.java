package mxz.service.impl;

import mxz.commons.utils.NewIDStamp;
import mxz.dao.AuditPageDao;
import mxz.dao.BusinessLicenseInfoDao;
import mxz.entity.AuditPage;
import mxz.entity.BusinessLicenseInfo;
import mxz.service.AuditPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class AuditPageServiceImpl implements AuditPageService {
    @Autowired
    private AuditPageDao auditPageDao;
    @Autowired
    private BusinessLicenseInfoDao businessLicenseInfoDao;

    public BusinessLicenseInfoDao getBusinessLicenseInfoDao() {
        return businessLicenseInfoDao;
    }

    public void setBusinessLicenseInfoDao(BusinessLicenseInfoDao businessLicenseInfoDao) {
        this.businessLicenseInfoDao = businessLicenseInfoDao;
    }

    public AuditPageDao getAuditPageDao() {
        return auditPageDao;
    }

    public void setAuditPageDao(AuditPageDao auditPageDao) {
        this.auditPageDao = auditPageDao;
    }

    @Transactional
    @Override
    public Integer add(AuditPage auditPage , BusinessLicenseInfo businessLicenseInfo) {
        //添加审核单id
        String auditPageId = auditPage.getType() + NewIDStamp.createNewIDStamp();
        auditPage.setAuditPageId(auditPageId);
        businessLicenseInfo.setAuditPageId(auditPageId);
        //将营业执照信息添加新建时间戳后写入数据库
        businessLicenseInfo.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        if(businessLicenseInfoDao.add(businessLicenseInfo) == 0){
            throw new RuntimeException("营业执照信息插入失败");
        };
        //为审核单添加新建时间戳后写入数据库
        auditPage.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        return auditPageDao.add(auditPage);
    }

    @Override
    public Integer update(AuditPage auditPage) {

        auditPage.setUpdateDateTime(new Timestamp(System.currentTimeMillis()));
        return auditPageDao.update(auditPage);
    }

    @Override
    public ArrayList<AuditPage> findByPageState(Integer state) {
        return null;
    }

    @Override
    public ArrayList<AuditPage> findByUid(String uid) {
        //根据用户id查询审核单
        ArrayList<AuditPage> auditList = auditPageDao.findByUid(uid);
        for (AuditPage auditPage : auditList){
            auditPage.setBusinessLicenseInfo(businessLicenseInfoDao.findByAuditPageId(auditPage.getAuditPageId()));
        }
        return auditList;
    }

    @Override
    public ArrayList<AuditPage> auditByUserType(Integer type) {
        //查找待审核的商家审核单
        ArrayList<AuditPage> result = auditPageDao.findPage(type,2);
        //为每个查询到的审核单添加营业执照信息
        for (AuditPage ap : result) {
            ap.setBusinessLicenseInfo(businessLicenseInfoDao.findByAuditPageId(ap.getAuditPageId()));
        }
        return result;
    }

    @Override
    public BusinessLicenseInfo findByBLInfoPageId(String auditPageId) {
        return businessLicenseInfoDao.findByAuditPageId(auditPageId);
    }

    @Override
    public Integer delete(String auditPageId) {
        return auditPageDao.delete(auditPageId);
    }

    @Override
    public AuditPage findByPageId(String auditPageId) {
        return null;
    }
}
