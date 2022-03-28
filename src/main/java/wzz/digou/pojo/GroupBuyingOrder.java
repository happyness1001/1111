package wzz.digou.pojo;

import java.util.ArrayList;
import java.util.Date;

public class GroupBuyingOrder {
    private String orderId;//订单ID
    private String productId;//产品ID
    private String marketId;//商户ID
    private ArrayList<GroupMemberOrder> memberOrders;//团员订单集合
    private Date groupSuccessTime;//成团时间

    private int aimNum;
    private int curNum;

    public GroupBuyingOrder() {
    }

    public GroupBuyingOrder(String productId, String marketId, ArrayList<GroupMemberOrder> memberOrders) {
        this.productId = productId;
        this.marketId = marketId;
        this.memberOrders = memberOrders;
    }

    public GroupBuyingOrder(String productId, String marketId, ArrayList<GroupMemberOrder> memberOrders, int aimNum, int curNum) {
        this.productId = productId;
        this.marketId = marketId;
        this.memberOrders = memberOrders;
        this.aimNum = aimNum;
        this.curNum = curNum;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public ArrayList<GroupMemberOrder> getMemberOrders() {
        return memberOrders;
    }

    public void setMemberOrders(ArrayList<GroupMemberOrder> memberOrders) {
        this.memberOrders = memberOrders;
    }

    public void addMemberOrder(GroupMemberOrder groupMemberOrder) {
        this.memberOrders.add(groupMemberOrder);
    }

    public Date getGroupSuccessTime() {
        return groupSuccessTime;
    }

    public void setGroupSuccessTime(Date groupSuccessTime) {
        this.groupSuccessTime = groupSuccessTime;
    }

    public int getAimNum() {
        return aimNum;
    }

    public void setAimNum(int aimNum) {
        this.aimNum = aimNum;
    }

    public int getCurNum() {
        return curNum;
    }

    public void setCurNum(int curNum) {
        this.curNum = curNum;
    }
}
