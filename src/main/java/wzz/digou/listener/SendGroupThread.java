package wzz.digou.listener;

import wzz.digou.controller.BulkController;
import wzz.digou.pojo.GroupBuyingOrder;
import wzz.digou.pojo.GroupMemberOrder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SendGroupThread extends Thread {
    public void run() {
        while (!this.isInterrupted()) {
            try {
                Thread.sleep(2000);
                synchronized (BulkController.bulkOrderslist) {
                    if (BulkController.bulkOrderslist.size() == 0) {
                        System.out.println("团购-队列长度为0，线程进入等待队列");
                        BulkController.bulkOrderslist.wait();
//                        System.out.println("移除队列" + ForeController.normalOrderslist.remove());
                        GroupBuyingOrder groupOrder = BulkController.bulkOrderslist.remove();
                        sendToTradingMidOffice(groupOrder);
                    } else {
                        System.out.println("团购-队列不为空");
//                        System.out.println(Arrays.toString(ForeController.normalOrderslist.toArray()));
                        GroupBuyingOrder groupOrder = BulkController.bulkOrderslist.remove();
                        sendToTradingMidOffice(groupOrder);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("从后台 向交易中台发送团购订单的线程正在执行......");
        }
    }

    //生成id + 将normalOrder传给交易中台
    public void sendToTradingMidOffice(GroupBuyingOrder groupBuyingOrder) {
        for (GroupMemberOrder mo : groupBuyingOrder.getMemberOrders()) {
            if (mo.getOrderId() == null) {
                String moPK = generatePK('7');
                mo.setOrderId(moPK);
            }
        }
        if (groupBuyingOrder.getOrderId() == null) {
            String no = generatePK('7');
            groupBuyingOrder.setOrderId(no);
        }

        //将groupBuyingOrder传给交易中台

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
