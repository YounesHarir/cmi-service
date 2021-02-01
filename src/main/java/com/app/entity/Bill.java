package com.app.entity;

import lombok.*;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Bill {
    private Long id;
    private double amount;
    private Date billingDate;
    private Date payedDate;
    private boolean payed;
    private boolean isBatched;
    private String codeCreance;

    public boolean getPayed(){
        return payed;
    }
}
