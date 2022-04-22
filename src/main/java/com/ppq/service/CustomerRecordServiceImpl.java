package com.ppq.service;

import com.ppq.dao.CustomerRecordMapper;
import com.ppq.pojo.CustomerRecord;

public class CustomerRecordServiceImpl implements CustomerRecordService {
    private CustomerRecordMapper customerRecordMapper;

    public void setCustomerRecordMapper(CustomerRecordMapper customerRecordMapper) {
        this.customerRecordMapper = customerRecordMapper;
    }

    @Override
    public String selectRecordByPrimaryKey(int customerId) {
        return customerRecordMapper.selectRecordByPrimaryKey(customerId);
    }

    @Override
    public int updateByPrimaryKeySelective(CustomerRecord customerRecord) {
        return customerRecordMapper.updateByPrimaryKeySelective(customerRecord);
    }
}
