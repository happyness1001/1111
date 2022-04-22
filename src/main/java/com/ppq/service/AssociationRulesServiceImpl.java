package com.ppq.service;

import com.ppq.dao.AssociationRulesMapper;
import com.ppq.pojo.AssociationRules;

import java.util.List;

public class AssociationRulesServiceImpl implements AssociationRulesService {
    private AssociationRulesMapper associationRulesMapper;

    public void setAssociationRulesMapper(AssociationRulesMapper associationRulesMapper) {
        this.associationRulesMapper = associationRulesMapper;
    }

    @Override
    public List<AssociationRules> selectRules() {
        return associationRulesMapper.selectRules();
    }

    @Override
    public int deleteRules(int id) {
        return associationRulesMapper.deleteRules(id);
    }

    @Override
    public int addRules(AssociationRules associationRules) {
        return associationRulesMapper.addRules(associationRules);
    }
}
