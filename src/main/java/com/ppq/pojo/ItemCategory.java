package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategory {
    private String categoryNumber;
    private int categoryLevel;
    private String categoryName;
}
