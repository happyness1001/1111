package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberItem {
    private int id;
    private String itemNumber;
    private String itemName;
    private int memberLevel;
    private double memberPrice;
}
