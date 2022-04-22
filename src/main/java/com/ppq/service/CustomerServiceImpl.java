package com.ppq.service;

import com.ppq.dao.CustomerMapper;
import com.ppq.pojo.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private CustomerMapper customerMapper;
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerMapper.selectAllCustomer();
    }

    @Override
    public int insertSelective(Customer record) {
        return customerMapper.insertSelective(record);
    }

    @Override
    public Customer selectByPrimaryKey(int customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(int customerId) {
        return customerMapper.deleteByPrimaryKey(customerId);
    }
}
