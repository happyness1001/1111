package gsh.pojo;

import java.util.ArrayList;
import java.util.Date;

//ToB团购父类
public class GroupBuyingOrderToB extends AbstractOrder {

    private String orderId;//拼团总订单Id
    private ArrayList<GroupMemberOrderToB> memberOrders;//拼团子订单
    private Date groupSuccessTime;//拼团成功时间（成团时间）
    private Address sendAddress;//发货地址
    private String productId;//商品Id

    public ArrayList<GroupMemberOrderToB> getMemberOrders() {
        return memberOrders;
    }

    public void setMemberOrders(ArrayList<GroupMemberOrderToB> memberOrders) {
        this.memberOrders = memberOrders;
    }

    public Date getGroupSuccessTime() {
        return groupSuccessTime;
    }

    public void setGroupSuccessTime(Date groupSuccessTime) {
        this.groupSuccessTime = groupSuccessTime;
    }

    public Address getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(Address sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public GroupBuyingOrderToB(String orderId, ArrayList<GroupMemberOrderToB> memberOrders, Date groupSuccessTime, Address sendAddress, String productId) {
        this.orderId = orderId;
        this.memberOrders = memberOrders;
        this.groupSuccessTime = groupSuccessTime;
        this.sendAddress = sendAddress;
        this.productId = productId;
    }

    public GroupBuyingOrderToB() {
    }
}
