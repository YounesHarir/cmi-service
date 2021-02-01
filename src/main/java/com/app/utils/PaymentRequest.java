package com.app.utils;

import com.app.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class PaymentRequest {
    private Bill bill;
    private String creancier;
    private String accountID;

}
