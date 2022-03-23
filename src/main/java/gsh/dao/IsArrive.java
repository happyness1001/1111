package gsh.dao;

import org.springframework.stereotype.Repository;

@Repository
//确认货物是否到达
public class IsArrive {

    public boolean isArrive(String OrderId) {
//      if(送达)

        // if (new CommodityIml.getCommodityByID(String productId).getStatus())==5 ;
        return true;
    }
}
