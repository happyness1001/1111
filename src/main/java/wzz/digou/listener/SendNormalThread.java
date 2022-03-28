package wzz.digou.listener;

import wzz.digou.controller.ForeController;
import wzz.digou.pojo.NormalMemberOrder;
import wzz.digou.pojo.NormalOrder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SendNormalThread extends Thread {

//测试向交易中台发送普通订单-------test成功------流程正确---------------------------------------
//2021-12-20
//    public void run(){
//        while (!this.isInterrupted()){
//            try {
//                Thread.sleep(2000);
//                synchronized (TestController.list){
//                    if (TestController.list.size() == 0) {
//                        System.out.println("队列长度为0，线程进入等待队列");
//                        TestController.list.wait();
//                        System.out.println("移除队列" + TestController.list.remove());
//                    }else {
//                        System.out.println("队列不为空");
//                        System.out.println(Arrays.toString(TestController.list.toArray()));
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("从后台 向交易中台发送正常订单的线程正在执行......");
//        }
//    }
///测试向交易中台发送普通订单-------test成功------流程正确---------------------------------------

    public void run() {
        while (!this.isInterrupted()) {
            try {
                Thread.sleep(2000);
                synchronized (ForeController.normalOrderslist) {
                    if (ForeController.normalOrderslist.size() == 0) {
                        System.out.println("队列长度为0，线程进入等待队列");
                        ForeController.normalOrderslist.wait();
//                        System.out.println("移除队列" + ForeController.normalOrderslist.remove());
                        NormalOrder normalOrder = ForeController.normalOrderslist.remove();
                        sendToTradingMidOffice(normalOrder);
                    } else {
                        System.out.println("队列不为空");
//                        System.out.println(Arrays.toString(ForeController.normalOrderslist.toArray()));
                        NormalOrder normalOrder = ForeController.normalOrderslist.remove();
                        sendToTradingMidOffice(normalOrder);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("从后台 向交易中台发送正常订单的线程正在执行......");
        }
    }

    //生成id + 将normalOrder传给交易中台
    public void sendToTradingMidOffice(NormalOrder normalOrder) {
        for (NormalMemberOrder mo : normalOrder.getNormalMemberOrders()) {
            String moPK = generatePK('6');
            mo.setOrderId(moPK);
        }
        String no = generatePK('6');
        normalOrder.setOrderId(no);
        //将normalOrder传给交易中台
    }

    //生成订单id
    public String generatePK(char identification) {
        int[] weight = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        long summary = 0;
        int[] timestamp = generateTimeStamp();
        for (int i = 0; i < 16; i++) {
            summary += timestamp[i] * weight[i];
        }
        int remainder = (int) (summary % 11);
        Map<Integer, String> remainderMap = new HashMap<Integer, String>();
        remainderMap.put(0, "1");
        remainderMap.put(1, "0");
        remainderMap.put(2, "X");
        remainderMap.put(3, "9");
        remainderMap.put(4, "8");
        remainderMap.put(5, "7");
        remainderMap.put(6, "6");
        remainderMap.put(7, "5");
        remainderMap.put(8, "4");
        remainderMap.put(9, "3");
        remainderMap.put(10, "2");
        String pk = identification + Arrays.toString(timestamp).replaceAll(", ", "").replace("[", "").replace("]", "") + remainderMap.get(remainder);
        System.out.println(pk.length());
        return pk;
    }

    //获取时间戳
    public int[] generateTimeStamp() {
        long l = System.currentTimeMillis() * 1000L + (System.nanoTime() % 1000L);
        String num = String.valueOf(l);
        int[] res = new int[16];
        for (int i = 0; i < 16; i++) {
            res[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return res;
    }
}
