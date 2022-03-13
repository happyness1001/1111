package mxz.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

//审核单
@Data
public class AuditPage {
    private String auditPageId;//审核单id
    private String uid;//待审核用户id
    private BusinessLicenseInfo businessLicenseInfo;//营业执照信息
    private Integer state;//审核单状态:0表示审核失败，1代表审核成功，2表示待审核
    private Integer type;//审核单类型:1表示供应商类型，2表示店铺类型。
    private Integer managerId;//处理人员id
    private String remark;//审核意见
    private Timestamp createDateTime;//创建时间
    private Timestamp updateDateTime;//修改时间

}
