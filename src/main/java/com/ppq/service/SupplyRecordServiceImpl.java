package com.ppq.service;

import com.ppq.dao.SupplyRecordMapper;
import com.ppq.pojo.SupplyRecord;

import java.util.List;

public class SupplyRecordServiceImpl implements SupplyRecordService{
    private SupplyRecordMapper supplyRecordMapper;

    public void setSupplyRecordMapper(SupplyRecordMapper supplyRecordMapper) {
        this.supplyRecordMapper = supplyRecordMapper;
    }

    @Override
    public List<SupplyRecord> selectAllSupplyRecord() {
        return supplyRecordMapper.selectAllSupplyRecord();
    }

    @Override
    public int insertSelective(SupplyRecord record) {
        return supplyRecordMapper.insertSelective(record);
    }

    @Override
    public SupplyRecord selectByPrimaryKey(int recordId) {
        return supplyRecordMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByPrimaryKeySelective(SupplyRecord record) {
        return supplyRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(int recordId) {
        return supplyRecordMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public List<SupplyRecord> selectSupplyRecordByCategory(String category) {
        return supplyRecordMapper.selectSupplyRecordByCategory(category);
    }
}
