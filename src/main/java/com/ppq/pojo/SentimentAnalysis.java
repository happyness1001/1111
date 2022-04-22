package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SentimentAnalysis {
    //自增主键
    private int textId;
    private String text;
    //1为正面评价,2为负面评价
    private String textCategory;
}
