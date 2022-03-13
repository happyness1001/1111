package gsh.pojo;

import java.util.ArrayList;
import java.util.Date;

public class NormalBuyingToB extends AbstractOrder{

    private String orderId;//普通订单总ID
    private ArrayList<NormalOrderToB> normalOrderToB;//普通交易子订单
    private String marketId;//商户id
    private double amount;//订单金额
    private Bill bill;//账单
    private Address deliveryAddress;//收货地址
    private Date placeTime;//下单时间

    public NormalBuyingToB() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ArrayList<NormalOrderToB> getNormalOrderToB() {
        return normalOrderToB;
    }

    public void setNormalOrderToB(ArrayList<NormalOrderToB> normalOrderToB) {
        this.normalOrderToB = normalOrderToB;
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

    public NormalBuyingToB(String orderId, ArrayList<NormalOrderToB> normalOrderToB, String marketId, double amount, Bill bill, Address deliveryAddress, Date placeTime) {
        this.orderId = orderId;
        this.normalOrderToB = normalOrderToB;
        this.marketId = marketId;
        this.amount = amount;
        this.bill = bill;
        this.deliveryAddress = deliveryAddress;
        this.placeTime = placeTime;
    }
}
