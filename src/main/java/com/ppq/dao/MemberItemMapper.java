package com.ppq.dao;


import com.ppq.pojo.MemberItem;

import java.util.List;

public interface MemberItemMapper {
    List<MemberItem> selectAllMemberItem();
    int insertSelective(MemberItem record);
    MemberItem selectByPrimaryKey(int id);
    int updateByPrimaryKeySelective(MemberItem record);
    int deleteByPrimaryKey(int id);
}
