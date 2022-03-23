package gsh.pojo;


import java.util.ArrayList;
import java.util.Date;

public class GroupBuyingOrderToC extends AbstractOrder {
    private String orderId;//订单ID
    private String productId;//产品ID
    private String marketId;//商户ID
    private ArrayList<GroupMemberOrderToC> memberOrders;//团员订单集合
    private Date groupSuccessTime;//成团时间

    public GroupBuyingOrderToC(String orderId, String productId, String marketId, ArrayList<GroupMemberOrderToC> memberOrders, Date groupSuccessTime) {
        this.orderId = orderId;
        this.productId = productId;
        this.marketId = marketId;
        this.memberOrders = memberOrders;
        this.groupSuccessTime = groupSuccessTime;
    }

    public GroupBuyingOrderToC() {
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

    public ArrayList<GroupMemberOrderToC> getMemberOrders() {
        return memberOrders;
    }

    public void setMemberOrders(ArrayList<GroupMemberOrderToC> memberOrders) {
        this.memberOrders = memberOrders;
    }

    public Date getGroupSuccessTime() {
        return groupSuccessTime;
    }

    public void setGroupSuccessTime(Date groupSuccessTime) {
        this.groupSuccessTime = groupSuccessTime;
    }
}


