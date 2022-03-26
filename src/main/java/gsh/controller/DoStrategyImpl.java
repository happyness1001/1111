package gsh.controller;

import gsh.dao.DoStrategy;
import gsh.pojo.AbstractOrder;
import gsh.pojo.StrategyActivity;
import gsh.service.StrategyFactory;
import org.springframework.stereotype.Controller;

@Controller
public class DoStrategyImpl implements DoStrategy {


    @Override
    public void doStrategyActivity(AbstractOrder abstractOrder) {
//        获得相应的Active策略
        StrategyActivity strategyActivity = new StrategyActivity(StrategyFactory.getStrategy(abstractOrder.getClass().getSimpleName()));
//        执行策略
        strategyActivity.execute(abstractOrder);

    }
}
