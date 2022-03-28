package wzz.digou.controller;

import wzz.digou.pojo.NormalMemberOrder;
import wzz.digou.pojo.NormalOrder;

import java.util.*;

public class creatOrderID {
    Queue<NormalOrder> list = new LinkedList<>();

    public void sendToTradingMidOffice() throws InterruptedException {
        while (true) {
            if (!list.isEmpty()) {
                NormalOrder normalOrder = list.remove();
                for (NormalMemberOrder mo : normalOrder.getNormalMemberOrders()) {
                    String moPK = generatePK('6');
                    mo.setOrderId(moPK);
                }
                String no = generatePK('6');
                normalOrder.setOrderId(no);
                //将normalOrder传给交易中台
                Thread.sleep(1);
            } else {
                Thread.sleep(100);
            }
        }
    }

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
