package gsh.service;

import gsh.dao.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StrategyFactory {

//    private static Map<Class, Strategy> ORDER_STRATEGY_MAP = new HashMap<Class, Strategy>();
//
//
//    static {
//        ORDER_STRATEGY_MAP.put(NormalBuyingToB.class, new NormalBuyingToBStrategy());
//        ORDER_STRATEGY_MAP.put(NormalBuyingToC.class, new NormalBuyingToCStrategy());
//        ORDER_STRATEGY_MAP.put(GroupBuyingOrderToB.class, new GroupBuyingToBStrategy());
//        ORDER_STRATEGY_MAP.put(GroupBuyingOrderToC.class, new GroupBuyingToCStrategy());
//        ORDER_STRATEGY_MAP.put(FuturesContract.class, new FuturesStrategy());
//        ORDER_STRATEGY_MAP.put(FuturesTransactionContract.class, new FuturesTransactionStrategy());
//        ORDER_STRATEGY_MAP.put(ConsignmentContract.class, new ConsignmentStrategy());
//    }
//
//    public static final Strategy NON_STRATEGY = new EmptyStrategy();
//
//    public StrategyFactory() {
//    }
//
//    public static Strategy getStrategy(Class C){
//        Strategy strategy = ORDER_STRATEGY_MAP.get(C);
//        return strategy == null ? NON_STRATEGY : strategy;
//    }
//
//    public static void main(String[] args) {
//        Strategy strategy = ORDER_STRATEGY_MAP.get(NormalBuyingToB.class);
//        System.out.println(strategy);
//    }


//    private static Map<AbstractOrder, Strategy> ORDER_STRATEGY_MAP = new HashMap<AbstractOrder, Strategy>();
//
//
//    private static final NormalBuyingToB NormalBuyingToB = new NormalBuyingToB();
//
//    private static final NormalBuyingToC NormalBuyingToC = new NormalBuyingToC();
//
//    private static final ConsignmentContract ConsignmentContract = new ConsignmentContract();
//
//    private static final GroupBuyingOrderToB GroupBuyingOrderToB = new GroupBuyingOrderToB();
//
//    private static final GroupBuyingOrderToC GroupBuyingOrderToC = new GroupBuyingOrderToC();
//
//    private static final FuturesContract FuturesContract = new FuturesContract();
//
//    private static final FuturesTransactionContract FuturesTransactionContract = new FuturesTransactionContract();
//
//    static {
//        ORDER_STRATEGY_MAP.put(NormalBuyingToB, new NormalBuyingToBStrategy());
//        ORDER_STRATEGY_MAP.put(NormalBuyingToC, new NormalBuyingToCStrategy());
//        ORDER_STRATEGY_MAP.put(GroupBuyingOrderToB, new GroupBuyingToBStrategy());
//        ORDER_STRATEGY_MAP.put(GroupBuyingOrderToC, new GroupBuyingToCStrategy());
//        ORDER_STRATEGY_MAP.put(FuturesContract, new FuturesStrategy());
//        ORDER_STRATEGY_MAP.put(FuturesTransactionContract, new FuturesTransactionStrategy());
//        ORDER_STRATEGY_MAP.put(ConsignmentContract, new ConsignmentStrategy());
//    }
//
//    public static final Strategy NON_STRATEGY = new EmptyStrategy();
//
//    public StrategyFactory() {
//    }
//
//    public static Strategy getStrategy(AbstractOrder abstractOrder){
//        Strategy strategy = ORDER_STRATEGY_MAP.get(abstractOrder);
//        return strategy == null ? NON_STRATEGY : strategy;
//    }
//
//    public static void main(String[] args) {
//        Strategy strategy = ORDER_STRATEGY_MAP.get(NormalBuyingToB.class);
//        System.out.println(strategy);
//    }
    @Autowired
    NormalBuyingToBStrategy normalBuyingToBStrategy;
    @Autowired
    NormalBuyingToCStrategy normalBuyingToCStrategy;
    @Autowired
    GroupBuyingToBStrategy groupBuyingToBStrategy;
    @Autowired
    GroupBuyingToCStrategy groupBuyingToCStrategy;
    @Autowired
    FuturesStrategy futuresStrategy;
    @Autowired
    FuturesTransactionStrategy futuresTransactionStrategy;
    @Autowired
    ConsignmentStrategy consignmentStrategy;
    @Autowired
    static
    EmptyStrategy NON_STRATEGY;


    private static Map<String, Strategy> ORDER_STRATEGY_MAP = new HashMap<String, Strategy>();

    @PostConstruct
    public void ConstructStrategyMap() {
//    public static final Strategy NON_STRATEGY = new EmptyStrategy();

        ORDER_STRATEGY_MAP.put(OrderKey.NormalBuyingToB, normalBuyingToBStrategy);
        ORDER_STRATEGY_MAP.put(OrderKey.NormalBuyingToC, normalBuyingToCStrategy);
        ORDER_STRATEGY_MAP.put(OrderKey.GroupBuyingOrderToB, groupBuyingToBStrategy);
        ORDER_STRATEGY_MAP.put(OrderKey.GroupBuyingOrderToC, groupBuyingToCStrategy);
        ORDER_STRATEGY_MAP.put(OrderKey.FuturesContract, futuresStrategy);
        ORDER_STRATEGY_MAP.put(OrderKey.FuturesTransactionContract, futuresTransactionStrategy);
        ORDER_STRATEGY_MAP.put(OrderKey.ConsignmentContract, consignmentStrategy);

    }
    public StrategyFactory() {
    }

    public static Strategy getStrategy(String OrderKey) {
        Strategy strategy = ORDER_STRATEGY_MAP.get(OrderKey);
        return strategy == null ? NON_STRATEGY : strategy;
    }

    private interface OrderKey {
        String NormalBuyingToB = "NormalBuyingToB";
        String NormalBuyingToC = "NormalBuyingToC";
        String GroupBuyingOrderToB = "GroupBuyingOrderToB";
        String GroupBuyingOrderToC = "GroupBuyingOrderToC";
        String FuturesContract = "FuturesContract";
        String FuturesTransactionContract = "FuturesTransactionContract";
        String ConsignmentContract = "ConsignmentContract";
    }


}
