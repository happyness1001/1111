package gsh.service;

import gsh.dao.*;
import gsh.pojo.ConsignmentContract;
import gsh.pojo.Logistics;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class ConsignmentStrategy implements Strategy<ConsignmentContract> {


    @Override
    public void doStrategy(ConsignmentContract consignmentContract) {

//        构造组合策略
        CombinationStrategy combinationStrategy = new CombinationStrategy();
//        提交合约单
        combinationStrategy.doCombinationStrategy(consignmentContract);
//        创建货运单
        Logistics logistics = new Logistics(consignmentContract.getProductId(), consignmentContract.getCount()/*, consignmentContract.getTransportMode(), consignmentContract.getSendAddress()*/, consignmentContract.getDeliveryAddress());
//        发送货运单
        combinationStrategy.doCombinationStrategy(logistics);
//        创建Timer
        Timer timer = new Timer();


//        开始观察是否支付，若支付成功则订单结束，若支付失败则继续等待支付
        TimerTask timerTask3 = new TimerTask() {
            @Override
            public void run() {
                if (new IsPay().isPay(consignmentContract.getOrderId())) {
                    System.out.println("支付成功，订单结束");
                    this.cancel();
                    timer.cancel();
//                    System.gc();
                } else System.out.println("支付失败");
            }
        };

//        对订单结算周期计时，到达时间开始调用支付
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("到达还款周期，进行支付");
//                   进行支付
                combinationStrategy.doCombinationStrategy(consignmentContract.getBill());
//                   确认是否支付
                timer.scheduleAtFixedRate(timerTask3, 1000, 1000);
            }
        };

//        如果已经签收则，开始计时。否则持续监听
//        确认收货
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                if (new IsArrive().isArrive(logistics.getProductId())) {
                    System.out.println(logistics.getProductId() + "已经签收");
//                    到达还款日调用还款
                    timer.schedule(timerTask2, new Date(Long.parseLong(consignmentContract.getBillingCycle())));
                    this.cancel();
                } else {
                    System.out.println(logistics.getProductId() + "还未签收");

                }
            }
        };


//        确认收货
//        timer.scheduleAtFixedRate(timerTask1,1000*60*60*24,1000*60);
//        test
        timer.scheduleAtFixedRate(timerTask1, 1000, 1000);


    }


}