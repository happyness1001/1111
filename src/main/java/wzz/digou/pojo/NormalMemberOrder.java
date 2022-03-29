package wzz.digou.pojo;

import java.util.Date;

public class NormalMemberOrder {
    private String orderId;//订单ID

    private String productId;//产品ID
//    private String marketId;//商户ID
    //    private int couponID;//优惠券ID
    private int quantity;//商品数量
    private Double amount;//支付总金额
    private Bill bill;//账单
    private Date deliveryTime;//签收时间
    private String remark;//用户订单备注

//    private String consumerId;//消费者ID
//    private Address address;//地址，深拷贝
//    private Date placeTime;//下单时间

    public NormalMemberOrder() {

    }

    public NormalMemberOrder(String productId, int quantity, Double amount, Bill bill, String remark) {
        this.productId = productId;

        this.quantity = quantity;
        this.amount = amount;
        this.bill = bill;
        this.remark = remark;
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

//    public String getMarketId() {
//        return marketId;
//    }
//
//    public void setMarketId(String marketId) {
//        this.marketId = marketId;
//    }

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
