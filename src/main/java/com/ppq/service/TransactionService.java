package com.ppq.service;

import com.ppq.pojo.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionService {
    List<Transaction> selectTransaction();
    Map<List<String>,Double> selectNumberGroupById(String beginDate, String endDate, int level, double support, double confidence);
}
