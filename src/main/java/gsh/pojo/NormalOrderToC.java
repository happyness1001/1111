package gsh.pojo;


import java.util.Date;

//普通订单TOC
public class NormalOrderToC {

    private String orderId;//订单ID
    private String productId;//产品ID
    private String marketId;//商户ID
    private int quantity;//商品数量
    private String couponId;//优惠券ID
    private double amount;//分订单金额
    private Date deliveryTime;//签收时间
    private String remark;//用户订单备注

    public NormalOrderToC(String orderId, String productId, String marketId, int quantity, String couponId, double amount, Date deliveryTime, String remark) {
        this.orderId = orderId;
        this.productId = productId;
        this.marketId = marketId;
        this.quantity = quantity;
        this.couponId = couponId;
        this.amount = amount;
        this.deliveryTime = deliveryTime;
        this.remark = remark;
    }

    public NormalOrderToC() {
    }
}
