package gsh.controller;

import gsh.dao.Strategy;
import gsh.pojo.AbstractOrder;
import gsh.service.NormalBuyingToBStrategy;

public class StrategyActivity {

    private Strategy strategy;

    public StrategyActivity(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(AbstractOrder abstractOrder) {
        strategy.doStrategy(abstractOrder);
    }

}
