package wzz.digou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wzz.digou.pojo.*;
import wzz.digou.service.BulkConfigService;

import java.util.*;

@Controller
@RequestMapping("")
public class BulkController {
    //用来存储所有的拼团成功的list
    public static Queue<GroupBuyingOrder> bulkOrderslist = new LinkedList<>();
    @Autowired
    BulkConfigService bulkConfigService;
    //用来存储所有的发起未拼团成功的list
    private ArrayList<GroupBuyingOrder> allGroup = new ArrayList<>();

    //    public void sendToTradingMidOffice() throws InterruptedException {
//        while (true){
//            if (!witeId.isEmpty()){
//                GroupBuyingOrder groupBuyingOrder = witeId.remove();
//                for (GroupMemberOrder mo : groupBuyingOrder.getMemberOrders()){
//                    if (mo.getOrderId()==null) {
//                        String moPK = generatePK('7');
//                        mo.setOrderId(moPK);
//                    }
//                }
//                if (groupBuyingOrder.getOrderId()==null){
//                    String no = generatePK('7');
//                    groupBuyingOrder.setOrderId(no);
//                }
//                if (groupBuyingOrder.getAimNum()==groupBuyingOrder.getCurNum()){
//                    //将normalOrder传给交易中台
//                }else {
//                    allGroup.add(groupBuyingOrder);
//                }
//                Thread.sleep(1);
//            }else {
//                Thread.sleep(100);
//            }
//        }
//    }
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

    //配置商品拼团信息
    @RequestMapping("configbulkproduct")
//    public void configbulk(BulkConfig bulkConfig, HttpSession hs){
    public void configbulk() {
        BulkConfig testAdd = new BulkConfig(1, 1, 100.1, 3, 1, new Date(), new Date());
        bulkConfigService.add(testAdd);
        System.out.println("配置商品的拼团信息");
    }

    //发起团购
    @RequestMapping("sponsorbulk")
    public void sponsorbulk() {
        //前端传入团购配置id、消费者id、购买数量num、购买地址、支付方式
        //根据团购id查询团购价格
        BulkConfig bulk = bulkConfigService.getBulkConfig(2);
//        System.out.println(bulk.getBulkprice());
        Bill bill = new Bill("AliPay", bulk.getBulkprice());
        CustomAddress address = new CustomAddress();
        GroupMemberOrder groupMemberOrder = new GroupMemberOrder("consumerId", 1, bulk.getBulkprice(), bill, address, new Date(), "");
        ArrayList<GroupMemberOrder> memberOrders = new ArrayList<>();
        memberOrders.add(groupMemberOrder);
        GroupBuyingOrder groupBuyingOrder = new GroupBuyingOrder("1", "1", memberOrders, bulk.getPopulation(), 1);

        synchronized (allGroup) {
            allGroup.add(groupBuyingOrder);
        }
        System.out.println("发起团购");
    }

    //参与团购
    @RequestMapping("joinbulk")
    public void joinbulk(GroupBuyingOrder groupBuyingOrder) {
        //前台传入一个GroupBuyingOrder、消费者id、购买数量num、购买地址、支付方式
        BulkConfig bulk = bulkConfigService.getBulkConfig(2);
        Bill bill = new Bill("AliPay", bulk.getBulkprice());
        CustomAddress address = new CustomAddress();
        GroupMemberOrder groupMemberOrder = new GroupMemberOrder("consumerId", 1, bulk.getBulkprice(), bill, address, new Date(), "");
        groupBuyingOrder.addMemberOrder(groupMemberOrder);
        groupBuyingOrder.setCurNum(groupBuyingOrder.getCurNum() + 1);
        if (groupBuyingOrder.getAimNum() == groupBuyingOrder.getCurNum()) {
            synchronized (bulkOrderslist) {
                bulkOrderslist.add(groupBuyingOrder);
                bulkOrderslist.notifyAll();
            }
        } else {
            synchronized (allGroup) {
                allGroup.add(groupBuyingOrder);
            }
        }
        System.out.println("参加团购");
    }
}
