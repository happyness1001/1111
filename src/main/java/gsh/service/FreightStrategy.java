package gsh.service;


import gsh.dao.IsTransport;
import gsh.dao.SendLogistics;
import gsh.pojo.Logistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;
@Service
public class FreightStrategy {

    @Autowired
    SendLogistics sendLogistics;
    @Autowired
    IsTransport isTransport;
    public void doFreight(Logistics logistics) {
//        发送货运单
//        SendLogistics sendLogistics = new SendLogistics();
        sendLogistics.SendLogistics(logistics);
        Timer timer = new Timer();
//        获取货物运输状态
//        创建Timer等待
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                if (isTransport.isTransport(logistics.getOrderId())) {
                    System.out.println(logistics.getOrderId() + "已经发货");
                    this.cancel();
                    timer.cancel();
                } else {
                    System.out.println(logistics.getOrderId() + "等待发货");
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
