package com.ppq.service;


import java.util.List;
import java.util.Map;

public interface CustomerTransactionService {
    Map<Integer,double[][]> selectAllOrderByDate(String beginDate, String endDate);
    double[][] getRegressionPoints(String beginDate, String endDate,int id);
}
