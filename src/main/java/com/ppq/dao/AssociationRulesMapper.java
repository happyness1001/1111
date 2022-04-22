package com.ppq.dao;

import com.ppq.pojo.AssociationRules;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssociationRulesMapper {
    List<AssociationRules> selectRules();
    int deleteRules(@Param("id") int id);
    int addRules(AssociationRules associationRules);
}
