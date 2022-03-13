package gsh.service;

import gsh.dao.IsPay;
import gsh.dao.Strategy;
import gsh.pojo.NormalBuyingToC;

import java.util.Timer;
import java.util.TimerTask;

public class NormalBuyingToCStrategy implements Strategy<NormalBuyingToC> {

    @Override
    public void doStrategy(NormalBuyingToC normalBuyingToC) {

//        构造组合策略
        final CombinationStrategy combinationStrategy = new CombinationStrategy();
//        创建IsPay
        final IsPay isPay = new IsPay();
//        创建Timer
        Timer timer = new Timer();


//        提交合约单
        combinationStrategy.doCombinationStrategy(normalBuyingToC);

//        进行支付
        combinationStrategy.doCombinationStrategy(normalBuyingToC.getBill());
//        确认是否支付成功
// ///////////////////////////////////////////////////////////////////////////////////////////////////限期支付/循环次数限制
        int number = 60 * 10;//循环600次(等待十分钟)
        TimerTask timerTask1 = new TimerTask() {
            int count = 0;//计数

            @Override
            public void run() {
                if (count < number) {
                    if (isPay.isPay(normalBuyingToC.getOrderId())) {
                        System.out.println("支付完成，订单完成");
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
