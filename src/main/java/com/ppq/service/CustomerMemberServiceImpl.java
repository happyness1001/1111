package com.ppq.service;

import com.ppq.dao.CustomerMemberMapper;
import com.ppq.pojo.CustomerMember;

import java.util.List;

public class CustomerMemberServiceImpl implements CustomerMemberService{
    private CustomerMemberMapper customerMemberMapper;

    public void setCustomerMemberMapper(CustomerMemberMapper customerMemberMapper) {
        this.customerMemberMapper = customerMemberMapper;
    }

    @Override
    public List<CustomerMember> selectAllCustomer() {
        return customerMemberMapper.selectAllCustomer();
    }

    @Override
    public int insertSelective(CustomerMember record) {
        return customerMemberMapper.insertSelective(record);
    }

    @Override
    public CustomerMember selectByPrimaryKey(int memberId) {
        return customerMemberMapper.selectByPrimaryKey(memberId);
    }

    @Override
    public int updateByPrimaryKeySelective(CustomerMember record) {
        return customerMemberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(int memberId) {
        return customerMemberMapper.deleteByPrimaryKey(memberId);
    }
}
