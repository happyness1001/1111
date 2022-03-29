package gsh.pojo;

import java.util.Date;

//TOB
public class NormalOrderToB extends AbstractOrder {

    private String orderId;//订单ID，flag+时间戳+MD5校验码
    private double amount;//分订单产品单价
    private String productId;// 商品id
    private int quantity;//数量

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    private String marketId;//商户id
    private int transportMode;//配送方式//////////////
    private Address sendAddress;//发货地址////////////
    private Date deliveryTime;//签收时间
    private String remark;//用户订单备注

    public NormalOrderToB() {

    }

    public NormalOrderToB(String orderId, double amount, String productId, int quantity, int transportMode, Address sendAddress, Date deliveryTime, String remark) {
        this.orderId = orderId;
        this.amount = amount;
        this.productId = productId;
        this.quantity = quantity;
        this.transportMode = transportMode;
        this.sendAddress = sendAddress;
        this.deliveryTime = deliveryTime;
        this.remark = remark;

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
