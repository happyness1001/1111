package com.ppq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMember {
    private int memberId;
    private int memberLevel;
    private int minPoints;
    private int maxPoints;
}
