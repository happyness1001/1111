package com.ppq.service;

import com.ppq.pojo.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> selectAllCustomer();
    int insertSelective(Customer record);
    Customer selectByPrimaryKey(int customerId);
    int updateByPrimaryKeySelective(Customer record);
    int deleteByPrimaryKey(int customerId);
}
