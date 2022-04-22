package com.ppq.dao;

import com.ppq.pojo.CustomerMember;

import java.util.List;

public interface CustomerMemberMapper {
    List<CustomerMember> selectAllCustomer();
    int insertSelective(CustomerMember record);
    CustomerMember selectByPrimaryKey(int memberId);
    int updateByPrimaryKeySelective(CustomerMember record);
    int deleteByPrimaryKey(int memberId);
}
