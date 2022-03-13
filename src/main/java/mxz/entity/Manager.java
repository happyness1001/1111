package mxz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Manager extends User{
    private String uid;//管理员id
    private String password;// 密码
    private String name;//用户名
    private Integer managerType;//管理员类型
    private Date createDateTime;//创建时间
    private Integer userType = 4;//用户类型

    public Manager(String name, String password, Integer userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;
    }
    public Manager(String name,String password) {
        this.password = password;
        this.name = name;
    }
}
