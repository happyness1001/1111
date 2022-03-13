package gsh.utils;
import java.util.Timer;
import java.util.TimerTask;

public class TimerUtil {

    public void doTimer(TimerTask timerTask,long delay,long intevalPeriod){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask,delay,intevalPeriod);
    }

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("进行循环");
            }
        };
        new TimerUtil().doTimer(timerTask,0,1000);
    }


}
