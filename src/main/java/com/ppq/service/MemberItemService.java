package com.ppq.service;

import com.ppq.pojo.MemberItem;

import java.util.List;

public interface MemberItemService {
    List<MemberItem> selectAllMemberItem();
    int insertSelective(MemberItem record);
    MemberItem selectByPrimaryKey(int id);
    int updateByPrimaryKeySelective(MemberItem record);
    int deleteByPrimaryKey(int id);
}
