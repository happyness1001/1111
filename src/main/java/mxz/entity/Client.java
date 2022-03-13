package mxz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
//普通顾客
@Data
@NoArgsConstructor
public class Client extends User{
    private String uid;//普通顾客id
    private String name;//普通顾客用户名
    private String password;//密码
    private String email;//用户邮箱
    private Integer sex;//用户性别
    private String phone;//用户电话
    private Date birthday;//用户生日
    private Address[] address;//用户收货地址
    private Date createDateTime;//账号创建时间
    private String trueName;//真实姓名
    private String ip;//ip地址
    private String remark;//签名
    private Integer userType;//用户类型

    public Client(String name, String password,  String phone, Integer userType) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }
    public Client(String name,String password) {
        this.password = password;
        this.name = name;
    }
}
