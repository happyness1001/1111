package gsh.pojo;

public class Logistics {

    private String productId;//商品id
    private int quantity;//数量
//    private int transportMode;//配送方式
//    private Address sendAddress;//签收地址
    private Address deliverAddress;//发货地址

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

    public Address getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(Address deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public Logistics(String productId, int quantity/*, int transportMode, Address sendAddress*/,Address deliverAddress) {
        this.productId = productId;
        this.quantity = quantity;
//        this.transportMode = transportMode;
//        this.sendAddress = sendAddress;
        this.deliverAddress = deliverAddress;
    }
    public Logistics(String productId, int quantity/*, int transportMode, Address sendAddress*/) {
        this.productId = productId;
        this.quantity = quantity;
//        this.transportMode = transportMode;
//        this.sendAddress = sendAddress;

    }
    public Logistics(String productId/*,Address sendAddress*/){
        this.productId = productId;
//        this.sendAddress = sendAddress;
    }
    public Logistics(Address deliverAddress){
        this.deliverAddress=deliverAddress;
    }


}
