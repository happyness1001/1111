package com.ppq.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerTransactionMapper {
    List<Map<Object,Object>> selectAllOrderByDate(@Param("beginDate")String beginDate,@Param("endDate") String endDate);
}
