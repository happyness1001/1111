package com.ppq.service;

import com.ppq.dao.MemberItemMapper;
import com.ppq.pojo.MemberItem;

import java.util.List;

public class MemberItemServiceImpl implements MemberItemService{
    private MemberItemMapper memberItemMapper;

    public void setMemberItemMapper(MemberItemMapper memberItemrMapper) {
        this.memberItemMapper = memberItemrMapper;
    }

    @Override
    public List<MemberItem> selectAllMemberItem() {
        return memberItemMapper.selectAllMemberItem();
    }

    @Override
    public int insertSelective(MemberItem record) {
        return memberItemMapper.insertSelective(record);
    }

    @Override
    public MemberItem selectByPrimaryKey(int id) {
        return memberItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MemberItem record) {
        return memberItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return memberItemMapper.deleteByPrimaryKey(id);
    }
}
