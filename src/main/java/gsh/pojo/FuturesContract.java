package gsh.pojo;

import java.util.Date;

//期货
public class FuturesContract extends AbstractOrder{

    private String orderId;//订单ID，flag+时间戳+MD5校验码
    private String productId;//商品id
    private String  shopId;//商户id
    private int amount;//订单总金额
    private Bill preBill;//账单
    private Bill endBill;//账单
    private int quantity;//商品数量
    private String penaltyRatio;//违约金比例
    private double handlingFee;//手续费

    private Date startTime;//预售开始时间
    private Date endTime;//预售结束时间
    private String prepaymentPercentage;//预付款支付百分比
    private Date redemptionTime;//交割时间
    private Date finalPaymentTime;//尾款支付时间

    private int transportMode;//配送方式
    private Address sendAddress;//签收地址
    private Address deliveryAddress;//发货地址

    private Date placeTime;//下单时间
    private Date deliveryTime;//签收时间
    private String remark;//用户订单备注


    public FuturesContract(String orderId, String productId, String shopId, Bill preBill, Bill endBill, int quantity, Date redemptionTime, Date finalPaymentTime, int transportMode, Address sendAddress, Address deliveryAddress) {
        this.orderId = orderId;
        this.productId = productId;
        this.shopId = shopId;
        this.preBill = preBill;
        this.endBill = endBill;
        this.quantity = quantity;
        this.redemptionTime = redemptionTime;
        this.finalPaymentTime = finalPaymentTime;
        this.transportMode = transportMode;
        this.sendAddress = sendAddress;
        this.deliveryAddress = deliveryAddress;
    }

    public FuturesContract() {

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

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Bill getPreBill() {
        return preBill;
    }

    public void setPreBill(Bill preBill) {
        this.preBill = preBill;
    }

    public Bill getEndBill() {
        return endBill;
    }

    public void setEndBill(Bill endBill) {
        this.endBill = endBill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPenaltyRatio() {
        return penaltyRatio;
    }

    public void setPenaltyRatio(String penaltyRatio) {
        this.penaltyRatio = penaltyRatio;
    }

    public double getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(double handlingFee) {
        this.handlingFee = handlingFee;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPrepaymentPercentage() {
        return prepaymentPercentage;
    }

    public void setPrepaymentPercentage(String prepaymentPercentage) {
        this.prepaymentPercentage = prepaymentPercentage;
    }

    public Date getRedemptionTime() {
        return redemptionTime;
    }

    public void setRedemptionTime(Date redemptionTime) {
        this.redemptionTime = redemptionTime;
    }

    public Date getFinalPaymentTime() {
        return finalPaymentTime;
    }

    public void setFinalPaymentTime(Date finalPaymentTime) {
        this.finalPaymentTime = finalPaymentTime;
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
