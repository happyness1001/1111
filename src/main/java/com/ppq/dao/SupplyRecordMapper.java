package com.ppq.dao;


import com.ppq.pojo.SupplyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplyRecordMapper {
    List<SupplyRecord> selectAllSupplyRecord();
    int insertSelective(SupplyRecord record);
    SupplyRecord selectByPrimaryKey(int recordId);
    int updateByPrimaryKeySelective(SupplyRecord record);
    int deleteByPrimaryKey(int recordId);
    List<SupplyRecord> selectSupplyRecordByCategory(@Param("category") String category);
}
