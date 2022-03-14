package gsh.dao;

import gsh.pojo.Logistics;
import ln.dlut.ln.controller.OrderController;

//传送地址
public class SendLogistics {

//    private Logistics logistics;


//    public void setLogistics(Logistics logistics) {
//        this.logistics = logistics;
//    }

    public void SendLogistics(Logistics logistics) {

//        调用发货接口
        new OrderController().getOrderFromCenter(logistics);
        System.out.println("等待发货");
    }

}
