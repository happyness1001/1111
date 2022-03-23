package gsh.pojo;

import java.util.Date;

//寄售
public class ConsignmentContract extends AbstractOrder {

    private String orderId;//订单ID，flag+时间戳+MD5校验码
    private String productId;//商品id
    private String marketId;//连锁店id
    private int count;//数量
    private double amount;//金额
    private Bill bill;//账单
    private String penaltyRatio;//违约金比例
    private double deposit;//押金
    private String billingCycle;//订单结算周期
    private double handlingFee;//手续费

    private int transportMode;//配送方式
    private Address sendAddress;//发货地址
    private Address deliveryAddress;//收货地址

    private Date placeTime;//下单时间
    private Date deliveryTime;//签收时间
    private String remark;//用户订单备注

    public ConsignmentContract(String orderId, String productId, String marketId, int count, double amount, Bill bill, String penaltyRatio, double deposit, String billingCycle, double handlingFee, int transportMode, Address sendAddress, Address deliveryAddress, Date placeTime, String remark) {
        this.orderId = orderId;
        this.productId = productId;
        this.marketId = marketId;
        this.count = count;
        this.amount = amount;
        this.bill = bill;
        this.penaltyRatio = penaltyRatio;
        this.deposit = deposit;
        this.billingCycle = billingCycle;
        this.handlingFee = handlingFee;
        this.transportMode = transportMode;
        this.sendAddress = sendAddress;
        this.deliveryAddress = deliveryAddress;
        this.placeTime = placeTime;
        this.remark = remark;
    }

    public ConsignmentContract() {

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getPenaltyRatio() {
        return penaltyRatio;
    }

    public void setPenaltyRatio(String penaltyRatio) {
        this.penaltyRatio = penaltyRatio;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public double getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(double handlingFee) {
        this.handlingFee = handlingFee;
    }

    public int getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(int transportMode) {
        this.transportMode = transportMode;
    }

    public Address getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(Address sendAddress) {
        this.sendAddress = sendAddress;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(Date placeTime) {
        this.placeTime = placeTime;
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
