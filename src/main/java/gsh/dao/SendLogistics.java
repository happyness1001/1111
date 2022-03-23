package gsh.dao;

import gsh.pojo.Logistics;
import ln.dlut.ln.controller.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
//传送地址
public class SendLogistics {
    @Autowired
    @Qualifier("orderController")
    private OrderController orderController;

//    private Logistics logistics;


//    public void setLogistics(Logistics logistics) {
//        this.logistics = logistics;
//    }

    public void SendLogistics(Logistics logistics) {
//        调用发货接口
        orderController.getOrderFromCenter(logistics);
        System.out.println("等待发货");
    }

}
