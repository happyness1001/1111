package com.ppq.service;

import com.ppq.pojo.CustomerMember;

import java.util.List;

public interface CustomerMemberService {
    List<CustomerMember> selectAllCustomer();
    int insertSelective(CustomerMember record);
    CustomerMember selectByPrimaryKey(int memberId);
    int updateByPrimaryKeySelective(CustomerMember record);
    int deleteByPrimaryKey(int memberId);
}
