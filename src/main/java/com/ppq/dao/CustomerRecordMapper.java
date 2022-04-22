package com.ppq.dao;

import com.ppq.pojo.CustomerRecord;
import org.apache.ibatis.annotations.Param;

public interface CustomerRecordMapper {
    String selectRecordByPrimaryKey(@Param("customerId") int customerId);
    int updateByPrimaryKeySelective(CustomerRecord customerRecord);
}
