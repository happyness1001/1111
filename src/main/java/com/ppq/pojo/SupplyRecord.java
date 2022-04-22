package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyRecord {
    private int recordId;
    private String supplierName;
    private String supplierPhone;
    private String supplyCategory;
    private int quality;
    private int price;
    private int quantity;
    private int total;
}
