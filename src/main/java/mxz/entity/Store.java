package mxz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//商超
@Data
@NoArgsConstructor
public class Store extends User {
    private String uid;//商超id
    private String password;//密码
    private String name;//商超名
    private String phone;//商超电话
    private Address address;//地址
    private String auditUrl;//审核信息地址
    private Integer isDeposit;//是否交保证金：1代表是，0代表否
    private String remark;//个性签名
    private Date createDateTime;//店铺创建时间
    private Integer userType;//用户类型

    public Store(String name, String password,  String phone, Integer userType) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }

    public Store(String name,String password) {
        this.password = password;
        this.name = name;
    }
}
