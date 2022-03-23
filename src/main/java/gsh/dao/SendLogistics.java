package gsh.dao;

import gsh.pojo.Logistics;
import org.springframework.stereotype.Repository;

@Repository
//传送地址
public class SendLogistics {

//    private Logistics logistics;


//    public void setLogistics(Logistics logistics) {
//        this.logistics = logistics;
//    }

    public void SendLogistics(Logistics logistics) {
//        调用发货接口
        System.out.println("等待发货");
    }

}
