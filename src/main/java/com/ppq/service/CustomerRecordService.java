package com.ppq.service;

import com.ppq.pojo.CustomerRecord;

public interface CustomerRecordService {
    String selectRecordByPrimaryKey(int customerId);
    int updateByPrimaryKeySelective(CustomerRecord customerRecord);
}
