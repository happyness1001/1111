package wzz.digou.pojo;

import java.util.ArrayList;
import java.util.Date;

public class NormalOrder {
    private String orderId;//普通订单总ID
    private CustomAddress deliveryAddress;//收货地址
    private ArrayList<NormalMemberOrder> normalMemberOrders;//正常订单
    private Date placeTime;//下单时间
    private String consumerId;//消费者ID
    private double amount;//订单总金额

//    private Bill bill;//账单
//    private String couponId;//优惠券ID

    public NormalOrder() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public CustomAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(CustomAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public ArrayList<NormalMemberOrder> getNormalMemberOrders() {
        return normalMemberOrders;
    }

    public void setNormalMemberOrders(ArrayList<NormalMemberOrder> normalMemberOrders) {
        this.normalMemberOrders = normalMemberOrders;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
