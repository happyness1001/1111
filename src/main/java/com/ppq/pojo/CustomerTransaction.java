package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTransaction {
    private int transactionId;
    private int customerId;
    private Date transactionDate;
}
