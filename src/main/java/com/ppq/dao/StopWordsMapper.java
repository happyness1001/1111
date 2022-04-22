package com.ppq.dao;


import com.ppq.pojo.StopWords;

import java.util.List;

public interface StopWordsMapper {
    int addWord(StopWords stopWords);
    List<String> queryAllWords();
}
