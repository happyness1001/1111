package gsh.service;

import gsh.dao.IsPay;
import gsh.dao.Strategy;
import gsh.pojo.FuturesTransactionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuturesTransactionStrategy implements Strategy<FuturesTransactionContract> {

    @Autowired
    CombinationStrategy combinationStrategy;
    @Autowired
    IsPay isPay;

    @Override
    public void doStrategy(FuturesTransactionContract futuresTransactionContract) {

//        构造组合策略
//        CombinationStrategy combinationStrategy = new CombinationStrategy();
//        提交合约单
        combinationStrategy.doCombinationStrategy(futuresTransactionContract);
//        如果前一个订单支付完成，提交下一个支付订单
        if (isPay.isPay(futuresTransactionContract.getOrderId())) {
            combinationStrategy.doCombinationStrategy(futuresTransactionContract.getBill());
        } else {
            System.out.println("前一个期货合同交易失败");
        }
    }
}
