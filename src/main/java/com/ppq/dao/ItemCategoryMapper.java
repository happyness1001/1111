package com.ppq.dao;

import com.ppq.pojo.ItemCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemCategoryMapper {
    String selectNameByNumber(@Param("number") String number);
    List<ItemCategory> fuzzyQueryByNumber(@Param("number") String number);
}
