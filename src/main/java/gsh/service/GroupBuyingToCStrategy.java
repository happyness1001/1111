package gsh.service;

import gsh.dao.IsPay;
import gsh.dao.Strategy;
import gsh.pojo.GroupBuyingOrderToC;
import gsh.pojo.GroupMemberOrderToC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class GroupBuyingToCStrategy implements Strategy<GroupBuyingOrderToC> {
    @Autowired
    CombinationStrategy combinationStrategy;
    @Autowired
    IsPay isPay;

    @Override
    public void doStrategy(GroupBuyingOrderToC groupBuyingOrderToC) {

//        构造组合策略
//        CombinationStrategy combinationStrategy = new CombinationStrategy();
//        创建Timer
        Timer timer = new Timer();
//        创建IsPay
//        IsPay isPay = new IsPay();


//        提交合约单
        combinationStrategy.doCombinationStrategy(groupBuyingOrderToC);
//        获取子订单
        ArrayList<GroupMemberOrderToC> memberOrders = groupBuyingOrderToC.getMemberOrders();
//        遍历子订单并执行支付
        for (GroupMemberOrderToC gC : memberOrders) {
            combinationStrategy.doCombinationStrategy(gC.getBill());
        }
//        遍历子订单并观察是都全部支付
// ///////////////////////////////////////////////////////////////////////////////////////////////////限期支付/循环次数限制
        int number = 60 * 10;//循环十分钟
        TimerTask timerTask1 = new TimerTask() {
            int count = 0;//计数

            @Override
            public void run() {
                if (count < number) {
                    int i = 0;
//                若支付成功则i++
                    for (GroupMemberOrderToC gC : memberOrders) {
                        if (isPay.isPay(gC.getOrderId())) i++;
                    }
//                若支付人数与订单人数相匹配则支付完成
                    if (i == memberOrders.size()) {
                        System.out.println("已全部支付完毕，订单结束");
                        timer.cancel();
                    }
                } else {
                    System.out.println("支付超时，取消订单");
                    timer.cancel();
                }
                count++;
            }
        };
//            第一次等待时间delay 1秒
//            第一次过后每次等待时间intevalPeriod 1秒
//            间隔时间
        timer.scheduleAtFixedRate(timerTask1, 1000, 1000);


    }

}
