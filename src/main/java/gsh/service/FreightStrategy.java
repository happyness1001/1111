package gsh.service;


import gsh.dao.IsTransport;
import gsh.dao.SendLogistics;
import gsh.pojo.Logistics;

import java.util.Timer;
import java.util.TimerTask;

public class FreightStrategy {

    public void doFreight(final Logistics logistics) {
//        发送货运单
        SendLogistics sendLogistics = new SendLogistics();
        sendLogistics.SendLogistics(logistics);
        Timer timer = new Timer();
//        获取货物运输状态
//        创建Timer等待
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                if (new IsTransport().isTransport(logistics.getProductId())) {
                    System.out.println(logistics.getProductId() + "已经发货");
                    this.cancel();
                    timer.cancel();
                } else {
                    System.out.println(logistics.getProductId() + "等待发货");
                }
            }
        };


//        第一次等待时间
        long delay = 0;
//        第一次过后每次等待时间
        long intevalPeriod = 1000;
//        执行延时
        timer.scheduleAtFixedRate(timerTask, delay, intevalPeriod);

    }

}
