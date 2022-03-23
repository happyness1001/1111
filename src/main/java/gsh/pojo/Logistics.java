package gsh.pojo;

public class Logistics {

    private String productId;//商品id
    private int quantity;//数量

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private String orderId;
//    private int transportMode;//配送方式
//    private Address sendAddress;//发货地址
    private Address deliverAddress;//收货地址
//  寄售信息
    public Logistics(String orderId,String productId, int quantity/*, int transportMode, Address sendAddress*/, Address deliverAddress) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
//        this.transportMode = transportMode;
//        this.sendAddress = sendAddress;
        this.deliverAddress = deliverAddress;
    }
//  期货信息
    public Logistics(String orderId,String productId, int quantity/*, int transportMode, Address sendAddress*/) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
//        this.transportMode = transportMode;
//        this.sendAddress = sendAddress;

    }
//  TOB团购
    public Logistics(String productId/*,Address sendAddress*/) {
        this.productId = productId;
//        this.sendAddress = sendAddress;
    }
//  TOB普通订单
    public Logistics(String orderId,Address deliverAddress) {
        this.orderId = orderId;
        this.deliverAddress = deliverAddress;
    }

//    public int getTransportMode() {
//        return transportMode;
//    }

//    public void setTransportMode(int distribution) {
//        this.transportMode = distribution;
//    }

//    public Address getSendAddress() {
//        return sendAddress;
//    }

//    public void setSendAddress(Address sendAddress) {
//        this.sendAddress = sendAddress;
//    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int count) {
        this.quantity = quantity;
    }

    public Address getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(Address deliverAddress) {
        this.deliverAddress = deliverAddress;
    }


}
