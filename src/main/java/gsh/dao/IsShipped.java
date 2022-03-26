package gsh.dao;

import ln.service.OrderCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class IsShipped {
    @Autowired
    @Qualifier("orderCommodityIml")
    private OrderCommodityService orderCommodityService;

    public boolean isShipped(String OrderId) {
//        if(发货)
        return orderCommodityService.isShipped(OrderId);
    }

}
