package gsh.service;

import gsh.dao.DoPay;
import gsh.dao.SendContract;
import gsh.pojo.AbstractOrder;
import gsh.pojo.Bill;
import gsh.pojo.Logistics;

public class CombinationStrategy {


    public void doCombinationStrategy(Object O) {


        if (O instanceof Bill) {//如果传入的是账单，则调用支付
            System.out.println("正在提交支付单");
            new DoPay().doPay((Bill) O);
        } else if (O instanceof Logistics) {//如果传入的是货运，则调用货运
            System.out.println(((Logistics) O).getProductId() + "正在提交货运单");
            new FreightStrategy().doFreight((Logistics) O);
        } else if (O instanceof AbstractOrder) {//如果传入的是合约，则调用合约单
            System.out.println("正在提交合约单");
            new SendContract().SendContract((AbstractOrder) O);
        } else System.out.println("传入错误分订单");//如果传入的并非是规定分订单，则返回该内容

    }

}
