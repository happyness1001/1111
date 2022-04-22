package com.ppq.dao;

import com.ppq.pojo.SentimentAnalysis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SentimentAnalysisMapper {
    //根据主键删除
    int deleteByPrimaryKey(@Param("textId")int textId);
    int insertSelective(SentimentAnalysis record);
    SentimentAnalysis selectByPrimaryKey(@Param("textId")int textId);
    int selectByText(@Param("text")String text);
    int updateByPrimaryKeySelective(SentimentAnalysis record);
    //查询所有记录
    List<SentimentAnalysis> selectAll();
    //查询所有正面的文本
    List<String> queryAllPositiveContent();
    //查询所有负面的文本
    List<String> queryAllNegativeContent();
}
