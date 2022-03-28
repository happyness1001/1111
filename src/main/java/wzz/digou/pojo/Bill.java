package wzz.digou.pojo;

public class Bill {
    private Double amount;//支付金额
    private String paymentWay;//支付方式

    public Bill(String paymentWay, Double amount) {
        this.amount = amount;
        this.paymentWay = paymentWay;
    }
}
