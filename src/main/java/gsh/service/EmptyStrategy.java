package gsh.service;

import gsh.dao.Strategy;
import gsh.pojo.AbstractOrder;

public class EmptyStrategy<Order> implements Strategy<Order> {

    @Override
    public void doStrategy(Order O){
        System.out.println("订单输入错误，无匹配策略");
    }

}
