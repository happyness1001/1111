package ln.service;

public interface OrderCommodityService {
    boolean isArrive(String orderId);
    boolean isSigned(String orderId);
    boolean isShipped(String orderId);
}
