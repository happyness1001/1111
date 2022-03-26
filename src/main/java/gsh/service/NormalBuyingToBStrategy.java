package gsh.service;

import gsh.dao.IsArrive;
import gsh.dao.IsPay;
import gsh.dao.Strategy;
import gsh.pojo.Logistics;
import gsh.pojo.NormalBuyingToB;
import gsh.pojo.NormalOrderToB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class NormalBuyingToBStrategy implements Strategy<NormalBuyingToB> {

    @Autowired
    public CombinationStrategy combinationStrategy;
    @Autowired
    public IsPay isPay;
    @Autowired
    public IsArrive isArrive;


    @Override
    public void doStrategy(NormalBuyingToB normalBuyingToB) {

//        构造组合策略
//        CombinationStrategy combinationStrategy = new CombinationStrategy();
//        创建Timer
        Timer timer = new Timer();
//        TimerManage timerManage = new TimerManage();
//        Timer timer = TimerManage.getTimer();
//        创建IsPay
//        IsPay isPay = new IsPay();
//        创建货运信息
        Logistics logistics = new Logistics(normalBuyingToB.getOrderId(), normalBuyingToB.getDeliveryAddress());
//        创建IsArrive
//        IsArrive isArrive = new IsArrive();
//        获取商品信息
        ArrayList<NormalOrderToB> normalOrderToB = normalBuyingToB.getNormalOrderToB();
//        提交合约单
        combinationStrategy.doCombinationStrategy(normalBuyingToB);
//        进行支付
        combinationStrategy.doCombinationStrategy(normalBuyingToB.getBill());


//        发货后遍历子订单是否全部发货成功
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                int i = 0;//统计签收次数
//                若签收则i++
                for (NormalOrderToB nB : normalOrderToB) {
                    if (isArrive.isArrive(nB.getOrderId())) i++;
                }
//                若签收人数与订单人数相匹配则订单完成
                if (i == normalOrderToB.size()) {
                    System.out.println("已全部签收，订单完成");
//                    timerManage.stopAllTimer();
//                    this.cancel();
//                    System.gc();
//                    timer.purge();
                    this.cancel();
                    timer.cancel();

                } else {

                    System.out.println("未全部签收");

                }
            }
        };

//        确认是否付款若付款成功则进行发货
//  //////////////////////////////////////////////////////////////////////////////////////////////////限期支付/循环次数限制
        int number = 60 * 10;//重复十分钟
        TimerTask timerTask1 = new TimerTask() {
            int count = 0;//计数

            @Override
            public void run() {
                if (count < number) {
                    if (isPay.isPay(normalBuyingToB.getOrderId())) {
                        System.out.println("已支付完毕");
                        //        支付成功之后调用发货,并补齐所有信息
                        for (NormalOrderToB nB : normalOrderToB) {
                            logistics.setProductId(nB.getProductId());
                            logistics.setQuantity(nB.getQuantity());
                            logistics.setOrderId(nB.getOrderId());
//                            logistics.setSendAddress(nB.getSendAddress());
                            combinationStrategy.doCombinationStrategy(logistics);
                        }

//                        test
                        timer.scheduleAtFixedRate(timerTask2, 1000, 1000);
//        确认子订单是否全部发完货    第一次等待时间delay1天,第一次过后每次等待时间intevalPeriod 10分钟
//                        timer.scheduleAtFixedRate(timerTask2,1000*60*60*24,1000*60*10);
                        this.cancel();
//                        System.out.println(timer.purge());
                    }
                } else {
                    System.out.println("超过支付时间，支付失败，取消订单");
                    timer.cancel();
                }
                count++;
            }
        };


//        确定是否全部支付完成       支付完成则调用发货。第一次等待时间delay 1秒，第一次过后每次等待时间intevalPeriod 1秒
        timer.scheduleAtFixedRate(timerTask1, 1000, 1000);


    }

}
