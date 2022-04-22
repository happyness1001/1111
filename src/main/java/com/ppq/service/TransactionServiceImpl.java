package com.ppq.service;

import com.ppq.dao.TransactionMapper;
import com.ppq.pojo.Transaction;
import com.ppq.utils.AssociationRuleUtils;

import java.util.*;

public class TransactionServiceImpl implements TransactionService {
    private TransactionMapper transactionMapper;

    public void setTransactionMapper(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    @Override
    public List<Transaction> selectTransaction() {
        return transactionMapper.selectTransaction();
    }

    @Override
    public Map<List<String>,Double> selectNumberGroupById(String beginDate, String endDate, int level, double support, double confidence) {
        //从数据库中获取指定时间段的交易记录,并根据交易单号进行分组
        List<String> lists = transactionMapper.selectNumberGroupById(beginDate, endDate);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            List<String> temp = new ArrayList<>();
            String[] split = lists.get(i).split(",");
            for (int j = 0; j < split.length; j++) {
                if(!temp.contains(split[j].substring(0,2*level))){
                    temp.add(split[j].substring(0,2*level));
                }
            }
            res.add(temp);
        }
        AssociationRuleUtils ruleUtils = new AssociationRuleUtils();
        Map<List<String>, Double> associationRules = ruleUtils.getAssociationRules(res, support, confidence);
        return associationRules;
    }


}
