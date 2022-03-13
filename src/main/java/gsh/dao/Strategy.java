package gsh.dao;


import gsh.pojo.AbstractOrder;
import gsh.pojo.NormalBuyingToC;

public interface Strategy<AbstractOrder> {

    public default void doStrategy(AbstractOrder abstractOrder) {
    }


}
