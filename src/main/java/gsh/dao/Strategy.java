package gsh.dao;


public interface Strategy<AbstractOrder> {

    public default void doStrategy(AbstractOrder abstractOrder) {
    }


}
