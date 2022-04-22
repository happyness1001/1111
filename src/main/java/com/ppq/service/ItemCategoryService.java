package com.ppq.service;

import com.ppq.pojo.AssociationRules;
import com.ppq.pojo.ItemCategory;


import java.util.List;
import java.util.Map;

public interface ItemCategoryService {
    String selectNameByNumber(String number);
    List<AssociationRules> getAssociationRules(Map<List<String>, Double> map);
    List<ItemCategory> fuzzyQueryByNumber(String number);
}
