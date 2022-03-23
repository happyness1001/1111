package gsh.service;

import gsh.dao.DoPay;
import gsh.dao.SendContract;
import gsh.pojo.AbstractOrder;
import gsh.pojo.Bill;
import gsh.pojo.Logistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CombinationStrategy {


    @Autowired
    DoPay doPay;
    @Autowired
    FreightStrategy freightStrategy;
    @Autowired(required = false)
    SendContract sendContract;

    public void doCombinationStrategy(Object O) {


        if (O instanceof Bill) {//如果传入的是账单，则调用支付
            System.out.println("正在提交支付单");
            doPay.doPay((Bill) O);
        } else if (O instanceof Logistics) {//如果传入的是货运，则调用货运
            System.out.println(((Logistics) O).getProductId() + "正在提交货运单");
            freightStrategy.doFreight((Logistics) O);
        } else if (O instanceof AbstractOrder) {//如果传入的是合约，则调用合约单
            System.out.println("正在提交合约单");
            sendContract.SendContract((AbstractOrder) O);
        } else System.out.println("传入错误分订单");//如果传入的并非是规定分订单，则返回该内容

    }

}
