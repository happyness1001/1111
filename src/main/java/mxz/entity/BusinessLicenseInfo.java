package mxz.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BusinessLicenseInfo {
    private int id;//营业执照信息id
    private String auditPageId;//审核单id
    private String corporateName;//公司名
    private String registrationNumber;//注册号（营业执照号）
    private String frName;//法人姓名
    private String idNumber;//法人身份证号
    private Byte[] frontOfIdCardPhoto;//法人身份证照片正面
    private Byte[] backOfIdCardPhoto;//法人身份证照片反面
    private String locationOfBusinessLicense;//营业执照所在地
    private String addressOfBusinessLicense;//营业执照详细地址
    private String dateOfIncorporation;//成立日期
    private Integer registeredCapital;//注册资本
    private String businessScope;//营业范围
    private Byte[] businessLicense;//营业执照副本电子版
    private String officePhone;//公司电话
    private String emergencyContact;//公司紧急联系人
    private String phoneOfEmergencyContact;//公司紧急联系人手机
    private Timestamp createDateTime;//创建时间
    private Timestamp updateDateTime;//更新时间

}
