package mxz.dao;

import mxz.entity.AuditPage;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface AuditPageDao {
    Integer add(AuditPage auditPage);
    Integer delete(String auditPageId);
    Integer update(AuditPage auditPage);
//    AuditPage findByPageId(String auditPageId);
    ArrayList<AuditPage> findByUid(String uid);
    //查找状态为state，类型为type的审核单
    ArrayList<AuditPage> findPage(@Param("type") Integer type, @Param("state") Integer state);
}
