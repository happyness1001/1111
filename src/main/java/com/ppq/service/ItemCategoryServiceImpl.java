package com.ppq.service;

import com.ppq.dao.ItemCategoryMapper;
import com.ppq.pojo.AssociationRules;
import com.ppq.pojo.ItemCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemCategoryServiceImpl implements ItemCategoryService {
    private ItemCategoryMapper itemCategoryMapper;

    public void setItemCategoryMapper(ItemCategoryMapper itemCategoryMapper) {
        this.itemCategoryMapper = itemCategoryMapper;
    }

    @Override
    public String selectNameByNumber(String number) {
        return itemCategoryMapper.selectNameByNumber(number);
    }

    @Override
    public List<AssociationRules> getAssociationRules(Map<List<String>, Double> map) {
        List<AssociationRules> result = new ArrayList<>();
        for (List<String> list : map.keySet()) {
            AssociationRules associationRules = new AssociationRules();
            associationRules.setPreItemNumber(list.get(0));
            associationRules.setPreItemName(selectNameByNumber(list.get(0)));
            associationRules.setPostItemNumber(list.get(1));
            associationRules.setPostItemName(selectNameByNumber(list.get(1)));
            associationRules.setConfidence(map.get(list));
            result.add(associationRules);
        }
        return result;
    }

    @Override
    public List<ItemCategory> fuzzyQueryByNumber(String number) {
        return itemCategoryMapper.fuzzyQueryByNumber(number);
    }
}
