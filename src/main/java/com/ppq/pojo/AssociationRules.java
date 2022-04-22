package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociationRules {
    private int id;
    private String preItemNumber;
    private String preItemName;
    private String postItemNumber;
    private String postItemName;
    private double confidence;
}
