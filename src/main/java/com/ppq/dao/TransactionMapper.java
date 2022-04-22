package com.ppq.dao;

import com.ppq.pojo.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {
    List<Transaction> selectTransaction();
    List<String> selectNumberGroupById(@Param("beginDate")String beginDate, @Param("endDate") String endDate);
}
