package com.ppq.service;

import com.ppq.pojo.SentimentAnalysis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SentimentAnalysisService {
    //查询所有记录
    List<SentimentAnalysis> selectAll();
    SentimentAnalysis selectByPrimaryKey(@Param("textId")int textId);
    int updateByPrimaryKeySelective(SentimentAnalysis record);
    int selectByText(@Param("text")String text);
    int deleteByPrimaryKey(@Param("textId")int textId);
    int insertSelective(SentimentAnalysis record);
    //查询所有正面的文本
    List<String> queryAllPositiveContent();
    //查询所有负面的文本
    List<String> queryAllNegativeContent();
}
