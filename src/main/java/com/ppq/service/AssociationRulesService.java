package com.ppq.service;

import com.ppq.pojo.AssociationRules;

import java.util.List;

public interface AssociationRulesService {
    List<AssociationRules> selectRules();
    int deleteRules(int id);
    int addRules(AssociationRules associationRules);
}
