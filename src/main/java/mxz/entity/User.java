package mxz.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private  String uid;//用户id
    private String name;//账户名
    private String password;//密码
    private Date createDateTime;//创建时间
    private Integer userType;//用户类型
}
