package com.ppq.service;

import com.ppq.pojo.SupplyRecord;

import java.util.List;

public interface SupplyRecordService {
    List<SupplyRecord> selectAllSupplyRecord();
    int insertSelective(SupplyRecord record);
    SupplyRecord selectByPrimaryKey(int recordId);
    int updateByPrimaryKeySelective(SupplyRecord record);
    int deleteByPrimaryKey(int recordId);
    List<SupplyRecord> selectSupplyRecordByCategory(String category);
}
