import java.util.Timer;
import java.util.TimerTask;

public class testUtil {

    public static void main(String[] args) {
        int number = 2;
        Timer timer = new Timer();
        TimerTask timerTask2 = new TimerTask() {
            int count = 0;//计数
            @Override
            public void run() {
                if (count < number) {
                    System.out.println("执行Task2");
                    count++;
                }else{
                    System.out.println("执行完成");
                    timer.cancel();
                }
            }
        };

        TimerTask timerTask1 = new TimerTask() {
            int count = 0;//计数
            @Override
            public void run() {
                if (count < number) {
                    System.out.println("执行Task1");
                    count++;
                }else{
                    timer.scheduleAtFixedRate(timerTask2,1000,1000);
                    this.cancel();
                }

            }
        };

        timer.scheduleAtFixedRate(timerTask1,1000,1000);
    }

}
