package gsh.pojo;

import java.util.ArrayList;
import java.util.Date;

public class NormalBuyingToC extends AbstractOrder{

    private String orderId;//普通订单总ID
    private Address deliveryAddress;//收货地址
    private ArrayList<NormalOrderToC> normalOrderToC;//正常订单
    private Date placeTime;//下单时间
    private String consumerId;//消费者ID
    private String couponId;//优惠券ID
    private double amount;//订单金额
    private Bill bill;//账单

    public NormalBuyingToC(String orderId, Address deliveryAddress, ArrayList<NormalOrderToC> normalOrderToC, Date placeTime, String consumerId, String couponId, double amount, Bill bill) {
        this.orderId = orderId;
        this.deliveryAddress = deliveryAddress;
        this.normalOrderToC = normalOrderToC;
        this.placeTime = placeTime;
        this.consumerId = consumerId;
        this.couponId = couponId;
        this.amount = amount;
        this.bill = bill;
    }

    public NormalBuyingToC() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public ArrayList<NormalOrderToC> getNormalOrderToC() {
        return normalOrderToC;
    }

    public void setNormalOrderToC(ArrayList<NormalOrderToC> normalOrderToC) {
        this.normalOrderToC = normalOrderToC;
    }

    public Date getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(Date placeTime) {
        this.placeTime = placeTime;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
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



}
