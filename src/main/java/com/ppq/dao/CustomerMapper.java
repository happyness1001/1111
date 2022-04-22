package com.ppq.dao;

import com.ppq.pojo.Customer;

import java.util.List;

public interface CustomerMapper {
    List<Customer> selectAllCustomer();
    int insertSelective(Customer record);
    Customer selectByPrimaryKey(int customerId);
    int updateByPrimaryKeySelective(Customer record);
    int deleteByPrimaryKey(int customerId);
}
