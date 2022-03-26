package gsh.service;

import gsh.dao.GetAddress;
import gsh.dao.IsArrive;
import gsh.dao.IsPay;
import gsh.dao.Strategy;
import gsh.pojo.FuturesContract;
import gsh.pojo.Logistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class FuturesStrategy implements Strategy<FuturesContract> {

    @Autowired
    CombinationStrategy combinationStrategy;
    @Autowired
    IsPay isPay;
    @Autowired
    IsArrive isArrive;
    @Autowired
    GetAddress deliverAddress;


    @Override
    public void doStrategy(final FuturesContract futuresContract) {

//        构造组合策略
//        CombinationStrategy combinationStrategy = new CombinationStrategy();
//        创建Timer
        Timer timer = new Timer();
//        创建IsPay
//        IsPay isPay = new IsPay();
//        创建货运信息
        Logistics logistics = new Logistics(futuresContract.getOrderId(), futuresContract.getProductId(), futuresContract.getQuantity()/*, futuresContract.getTransportMode(), futuresContract.getSendAddress()*/);
//        提交合约单
        combinationStrategy.doCombinationStrategy(futuresContract);
//        支付定金
        combinationStrategy.doCombinationStrategy(futuresContract.getPreBill());


//        如果已经签收则订单结束
        TimerTask timerTask5 = new TimerTask() {
            @Override
            public void run() {
                if (isArrive.isArrive(futuresContract.getOrderId())) {
                    System.out.println(futuresContract.getOrderId() + "已经签收，订单结束");
                    this.cancel();
                    timer.cancel();
//                    System.gc();
                } else {
                    System.out.println(futuresContract.getOrderId() + "还未签收");
                }
            }
        };

//        若已支付，跳出循环。开始对期货发货计时
        TimerTask timerTask4 = new TimerTask() {
            @Override
            public void run() {
//                    调取货运信息
//                GetAddress deliverAddress = new GetAddress();
                logistics.setDeliverAddress(deliverAddress.getAddress(futuresContract.getOrderId()));
//                    进行发货
                combinationStrategy.doCombinationStrategy(logistics);
//        判断是否已经签收
//                timer.scheduleAtFixedRate(timerTask5,1000*60*60*24,1000*60*10);
//                test
                timer.scheduleAtFixedRate(timerTask5, 1000, 1000);
                this.cancel();
            }
        };

//        判断尾款是否在规定时间内支付成功
//  //////////////////////////////////////////////////////////////////////////////////////////////////限期支付/循环次数限制
        int number3 = 60 * 60;//设置运行次数600次(一小时)
        TimerTask timerTask3 = new TimerTask() {
            int count = 0;    //从0开始计数，每运行一次timerTask次数加一，运行制定次数后结束。

            @Override
            public void run() {
//        在规定时间内重复查询是否支付成功
                if (count < number3) {
                    if (isPay.isPay(futuresContract.getOrderId())) {
                        System.out.println("尾款支付成功");
//        在发货时间进行发货
                        timer.schedule(timerTask4, futuresContract.getRedemptionTime());
                        this.cancel();
                    }
                } else {      //达到最大运行次数
                    System.out.println("超时，尾款支付失败");
//                    若尾款交付失败则订单中止
                    timer.cancel();
                }
                count++;
            }
        };


//        判断在交付尾款的时候之前款项是否结清，如果结清则进行下一步
        TimerTask timerTask2 = new TimerTask() {
            @Override
            public void run() {
                if (isPay.isPay(futuresContract.getOrderId())) {
//                    进行支付尾款支付
                    combinationStrategy.doCombinationStrategy(futuresContract.getEndBill());
//                    每次等待时间intevalPeriod 1秒
//                    间隔时间
                    timer.schedule(timerTask3, futuresContract.getFinalPaymentTime(), 1000);
                } else {
                    System.out.println("之前款项未结清，订单失效");
//                    若之前款项未结清则订单中止
                    timer.cancel();
                }
            }
        };


//        开始观察是否支付，若支付成功则订单继续，若一定时间内支付失败则结束
//  //////////////////////////////////////////////////////////////////////////////////////////////////限期支付/循环次数限制
        int number1 = 10 * 60;//设置运行次数600次(十分钟)
        TimerTask timerTask1 = new TimerTask() {
            int count = 0;    //从0开始计数，每运行一次timerTask次数加一，运行制定次数后结束。

            @Override
            public void run() {
                if (count < number1) {
                    if (isPay.isPay(futuresContract.getOrderId())) {
                        System.out.println("定金支付成功");
//        判断是之前的款项已经结清，若结清支付尾款————调用task3判断是都付清尾款
                        timer.schedule(timerTask2, futuresContract.getFinalPaymentTime());
                        this.cancel();
                    }
                } else {     //达到最大运行次数
                    System.out.println("超时，定金支付失败");
//                    若定金交付失败，则订单中止
                    timer.cancel();
                }
                count++;
            }
        };

//        判断是否支付定金
        timer.scheduleAtFixedRate(timerTask1, 1000, 1000);

    }

}
