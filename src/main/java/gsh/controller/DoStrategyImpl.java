package gsh.controller;

import gsh.dao.DoStrategy;
import gsh.pojo.AbstractOrder;
import gsh.service.StrategyFactory;
import java.lang.reflect.Parameter;

import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;

public class DoStrategyImpl implements DoStrategy {
    @Override
    public void doStrategyActivity(AbstractOrder abstractOrder) {
//        获得相应的Active策略
        StrategyActivity strategyActivity = new StrategyActivity(StrategyFactory.getStrategy(abstractOrder.getClass().getSimpleName()));
//        执行策略
        strategyActivity.execute(abstractOrder);

    }
}
