package com.ppq.service;


import com.ppq.dao.SentimentAnalysisMapper;
import com.ppq.pojo.SentimentAnalysis;

import java.util.List;

public class SentimentAnalysisImpl implements SentimentAnalysisService{
    private SentimentAnalysisMapper sentimentAnalysisMapper;

    public void setSentimentAnalysisMapper(SentimentAnalysisMapper sentimentAnalysisMapper) {
        this.sentimentAnalysisMapper = sentimentAnalysisMapper;
    }

    @Override
    public List<SentimentAnalysis> selectAll() {
        return sentimentAnalysisMapper.selectAll();
    }

    @Override
    public SentimentAnalysis selectByPrimaryKey(int textId) {
        return sentimentAnalysisMapper.selectByPrimaryKey(textId);
    }

    @Override
    public int updateByPrimaryKeySelective(SentimentAnalysis record) {
        return sentimentAnalysisMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int selectByText(String text) {
        return sentimentAnalysisMapper.selectByText(text);
    }

    @Override
    public int deleteByPrimaryKey(int textId) {
        return sentimentAnalysisMapper.deleteByPrimaryKey(textId);
    }

    @Override
    public int insertSelective(SentimentAnalysis record) {
        return sentimentAnalysisMapper.insertSelective(record);
    }

    @Override
    public List<String> queryAllPositiveContent() {
        return sentimentAnalysisMapper.queryAllPositiveContent();
    }

    @Override
    public List<String> queryAllNegativeContent() {
        return sentimentAnalysisMapper.queryAllNegativeContent();
    }
}
