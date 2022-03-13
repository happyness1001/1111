package gsh.service;

import gsh.dao.*;
import gsh.pojo.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class GroupBuyingToBStrategy implements Strategy<GroupBuyingOrderToB> {

    @Override
    public void doStrategy(GroupBuyingOrderToB groupBuyingOrderToB) {

//        构造组合策略
        CombinationStrategy combinationStrategy = new CombinationStrategy();
//        创建Timer
        Timer timer = new Timer();
//        创建IsPay
        IsPay isPay = new IsPay();
//        创建货运信息
        Logistics logistics = new Logistics(groupBuyingOrderToB.getProductId()/*, groupBuyingOrderToB.getSendAddress()*/);
//        创建IsArrive
        IsArrive isArrive = new IsArrive();

//        提交合约单
        combinationStrategy.doCombinationStrategy(groupBuyingOrderToB);
//        获取子订单
        ArrayList<GroupMemberOrderToB> memberOrders = groupBuyingOrderToB.getMemberOrders();
//        遍历子订单并执行支付
        for (GroupMemberOrderToB gB : memberOrders) {
            combinationStrategy.doCombinationStrategy(gB.getBill());
        }


//        发货后遍历子订单是否全部签收
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                int i = 0;
//                若签收则 i++
                for (GroupMemberOrderToB gB : memberOrders) {
                    if (isArrive.isArrive(gB.getOrderId())) i++;
                }
//                若签收人数与订单人数相匹配则支付完成
                if (i == memberOrders.size()) {
                    System.out.println("已全部签收，订单完成");
                    this.cancel();
//                    timer.cancel();
                    timer.cancel();
//                    System.gc();
                }
            }
        };

//        遍历子订单并观察是都全部支付
//  //////////////////////////////////////////////////////////////////////////////////////////////////限期支付/循环次数限制
        int number1 = 10 * 60;//设置运行次数600次(十分钟)
        TimerTask timerTask1 = new TimerTask() {
            int count = 0;    //从0开始计数，每运行一次timerTask次数加一，运行制定次数后结束。

            @Override
            public void run() {
                if (count < number1) {
                    int i = 0;
//                若支付成功则i++
                    for (GroupMemberOrderToB gB : memberOrders) {
                        if (isPay.isPay(gB.getOrderId())) i++;
                    }
//                若支付人数与订单人数相匹配则支付完成
                    if (i == memberOrders.size()) {
                        System.out.println("已全部支付完毕");
//                         支付成功之后调用发货,并补齐所有信息
                        for (GroupMemberOrderToB gB : memberOrders) {
                            logistics.setDeliverAddress(gB.getDeliverAddress());
                            logistics.setQuantity(gB.getQuantity());
//                            logistics.setTransportMode(gB.getTransportMode());
                            combinationStrategy.doCombinationStrategy(logistics);
                        }
//        判断是否全部签收，第一次等待时间delay 1天，第一次过后每次等待时间intevalPeriod 10分钟
//                        timer.scheduleAtFixedRate(timerTask2,1000*60*60*24,1000*60*60);
//                        test
                        timer.scheduleAtFixedRate(timerTask2, 1000, 1000);
                        this.cancel();
                    }
                } else {
//                    若超过最大循环次数，则订单失效
                    System.out.println("订单超时，支付失败");
                    timer.cancel();
                }
                count++;
            }
        };


//        判断是否全部支付成功
        timer.scheduleAtFixedRate(timerTask1, 1000, 1000);


    }


}
