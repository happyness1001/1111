package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int id;
    private int transactionId;
    private Date transactionDate;
    private String itemNumber;
    private String itemName;
    private double money;
}
