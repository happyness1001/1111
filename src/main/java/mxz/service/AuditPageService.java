package mxz.service;

import mxz.entity.AuditPage;
import mxz.entity.BusinessLicenseInfo;

import java.util.ArrayList;

public interface AuditPageService {
    Integer add(AuditPage auditPage, BusinessLicenseInfo businessLicenseInfo);

    Integer delete(String auditPageId);

    Integer update(AuditPage auditPage);

    AuditPage findByPageId(String auditPageId);

    ArrayList<AuditPage> findByPageState(Integer state);

    ArrayList<AuditPage> findByUid(String uid);

    ArrayList<AuditPage> auditByUserType(Integer type);

    BusinessLicenseInfo findByBLInfoPageId(String auditPageId);
}
