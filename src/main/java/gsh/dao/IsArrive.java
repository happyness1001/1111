package gsh.dao;

import ln.service.OrderCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
//确认货物是否到达
public class IsArrive {
    @Autowired
    @Qualifier("orderCommodityIml")
    private OrderCommodityService orderCommodityService;

    public boolean isArrive(String orderId) {
//      if(送达)
        orderCommodityService.isArrive(orderId);
        // if (new CommodityIml.getCommodityByID(String productId).getStatus())==5 ;
        return true;
    }
}
