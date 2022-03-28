package wzz.digou.pojo;

import java.util.Date;

public class GroupMemberOrder {
    private String orderId;
    private String consumerId;
    private int quantity;//数量
    private Double amount;//订单总金额
    private Bill bill;//账单
    private CustomAddress address;//地址，深拷贝
    private Date joinTime;//参团时间
    private Date deliveryTime;//签收时间
    private String remark;//用户订单备注

    public GroupMemberOrder() {
    }

    public GroupMemberOrder(String consumerId, int quantity, Double amount, Bill bill, CustomAddress address, Date joinTime, String remark) {
        this.consumerId = consumerId;
        this.quantity = quantity;
        this.amount = amount;
        this.bill = bill;
        this.address = address;
        this.joinTime = joinTime;
        this.remark = remark;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public CustomAddress getAddress() {
        return address;
    }

    public void setAddress(CustomAddress address) {
        this.address = address;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
