package com.ppq.service;

import com.ppq.dao.CustomerTransactionMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerTransactionServiceImpl implements CustomerTransactionService {
    private CustomerTransactionMapper customerTransactionMapper;

    public void setCustomerTransactionMapper(CustomerTransactionMapper customerTransactionMapper) {
        this.customerTransactionMapper = customerTransactionMapper;
    }


//    @Override
//    public Map<Integer,List<List<String>>> selectAllOrderByDate(String beginDate, String endDate) {
//        List<Map<Object, Object>> maps = customerTransactionMapper.selectAllOrderByDate(beginDate, endDate);
//        Map<Integer,List<List<String>>> res = new HashMap<>();
//        List<List<String>> points = new ArrayList<>();
//        for (Map<Object, Object> map : maps) {
//            if(!res.containsKey(map.get("customer_id"))){
//                points = new ArrayList<>();
//                res.put((Integer) map.get("customer_id"),points);
//                List<String> point = new ArrayList<>();
//                point.add((String) map.get("months"));
//                point.add(map.get("counts").toString());
//                points.add(point);
//            }else {
//                List<String> point = new ArrayList<>();
//                point.add((String) map.get("months"));
//                point.add(map.get("counts").toString());
//                points.add(point);
//            }
//        }
//
//        return res;
//    }
    /*
     *获取全部用户交易点的集合
     * @author ppq
     * @date 2021/3/6 22:47
     * @param [beginDate, endDate]
     * @return java.util.Map<java.lang.Integer,double[][]>
     */
    @Override
    public Map<Integer,double[][]> selectAllOrderByDate(String beginDate, String endDate) {
        List<Map<Object, Object>> maps = customerTransactionMapper.selectAllOrderByDate(beginDate, endDate);
        Map<Integer,List<Double>> collection = new HashMap<>();
        List<Double> points = new ArrayList<>();
        for (Map<Object, Object> map : maps) {
            if(!collection.containsKey(map.get("customer_id"))){
                points = new ArrayList<>();
                collection.put((Integer) map.get("customer_id"),points);
                points.add(Double.valueOf(map.get("counts").toString()));
            }else {
                points.add(Double.valueOf(map.get("counts").toString()));
            }
        }
        Map<Integer,double[][]> res = new HashMap<>();
        int index = 0;
        for (Integer integer : collection.keySet()) {
            List<Double> point = collection.get(integer);
            double[][] temp = new double[point.size()][2];
            for (Double integer1 : point) {
                temp[index][0] = index+1;
                temp[index++][1] = integer1;
            }
            res.put(integer,temp);
            index = 0;
        }
        return res;
    }

    /*获取指定用户交易点的集合
     * @author ppq
     * @date 2021/3/6 22:49
     * @param [beginDate, endDate, id]
     * @return double[][]
     */
    @Override
    public double[][] getRegressionPoints(String beginDate, String endDate,int id) {
        CustomerTransactionServiceImpl customerTransactionService = new CustomerTransactionServiceImpl();
        return customerTransactionService.selectAllOrderByDate(beginDate, endDate).get(id);
    }
}
