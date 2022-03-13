package gsh.pojo;

import java.util.Date;

//ToB团购子类
public class GroupMemberOrderToB {

    private String orderId;//订单ID，flag+时间戳+MD5校验码
    private String uId;//用户ID
    private int quantity;//数量
    private float amount;//支付金额
    private Bill bill;//账单
    private int transportMode;//配送方式
    private Address deliverAddress;//收货地址，深拷贝
    private Date joinTime;//参团时间
    private Date turnOverTime;//签收时间
    private String remark;//用户订单备注

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(int transportMode) {
        this.transportMode = transportMode;
    }

    public Address getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(Address deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getTurnOverTime() {
        return turnOverTime;
    }

    public void setTurnOverTime(Date turnOverTime) {
        this.turnOverTime = turnOverTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public GroupMemberOrderToB(String orderId, String uId, int quantity, float amount, Bill bill, int transportMode, Address deliverAddress, Date joinTime,  String remark) {
        this.orderId = orderId;
        this.uId = uId;
        this.quantity = quantity;
        this.amount = amount;
        this.bill = bill;
        this.transportMode = transportMode;
        this.deliverAddress = deliverAddress;
        this.joinTime = joinTime;
        this.remark = remark;
    }

}
