package gsh.pojo;

import gsh.dao.Strategy;

public class StrategyActivity {

    private Strategy strategy;

    public StrategyActivity(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(AbstractOrder abstractOrder) {
        strategy.doStrategy(abstractOrder);
    }

}
