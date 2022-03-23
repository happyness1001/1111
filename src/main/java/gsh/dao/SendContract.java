package gsh.dao;

import gsh.pojo.AbstractOrder;
import org.springframework.stereotype.Repository;

@Repository
//传送合约订单
public class SendContract {

//    private AbstractOrder abstractOrder;
//
//    public void setAbstractOrder(AbstractOrder abstractOrder) {
//        this.abstractOrder = abstractOrder;
//    }

    public void SendContract(AbstractOrder abstractOrder) {
//        调用提交合约单接口
        System.out.println("合约单提交完毕");
    }

}
