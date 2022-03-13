package mxz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Provider extends User{
    private String uid;//供应商id
    private String name;//供应商名称
    private String password;//密码
    private Integer isDeposit;//是否交保证金：1表示是，0表示否。
    private String phone;//厂家电话
    private Integer userType;//用户类型
    private Integer birthday;//建厂日期
    private Date createDateTime;//账号创建日期
    private String remark;//签名
    private Address address;//供应商地址

    public Provider(String name, String password, String phone, Integer userType) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }
    public Provider(String name,String password) {
        this.password = password;
        this.name = name;
    }
}

