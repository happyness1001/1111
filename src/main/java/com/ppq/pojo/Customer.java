package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int customerId;

    private String customerName;

    private String customerPhone;

    private String customerEmail;

    private String customerAddress;

    private double frequency;

    private int customerPoint;
}
