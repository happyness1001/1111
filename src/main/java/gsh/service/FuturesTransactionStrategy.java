package gsh.service;

import gsh.dao.*;
import gsh.pojo.FuturesTransactionContract;


public class FuturesTransactionStrategy implements Strategy<FuturesTransactionContract> {

    @Override
    public void doStrategy(FuturesTransactionContract futuresTransactionContract) {

//        构造组合策略
        CombinationStrategy combinationStrategy = new CombinationStrategy();
//        提交合约单
        combinationStrategy.doCombinationStrategy(futuresTransactionContract);
//        如果前一个订单支付完成，提交下一个支付订单
        if (new IsPay().isPay(futuresTransactionContract.getOrderId())) {
            combinationStrategy.doCombinationStrategy(futuresTransactionContract.getBill());
        } else {
            System.out.println("前一个期货合同交易失败");
        }
    }
}
