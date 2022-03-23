package gsh.pojo;

import java.util.Date;

public class FuturesTransactionContract extends AbstractOrder {

    private String orderId;//转手订单ID，flag+时间戳+MD5校验码
    private String futuresContractId;//期货合约ID
    private String marketId;//连锁店id
    private double amount;//订单总金额
    private Bill bill;//账单
    private Date placeTime;//下单时间
    private float penaltyRatio;//违约金比例
    private double handlingFee;//手续费
    private Address deliveryAddress;//签收地址
    private String remark;//用户订单备注

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFuturesContractId() {
        return futuresContractId;
    }

    public void setFuturesContractId(String futuresContractId) {
        this.futuresContractId = futuresContractId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
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

    public Date getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(Date placeTime) {
        this.placeTime = placeTime;
    }

    public float getPenaltyRatio() {
        return penaltyRatio;
    }

    public void setPenaltyRatio(float penaltyRatio) {
        this.penaltyRatio = penaltyRatio;
    }

    public double getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(double handlingFee) {
        this.handlingFee = handlingFee;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
