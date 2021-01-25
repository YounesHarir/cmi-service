package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Account {
    private String id;
    private String accountNumber;
    private double amount;
    private double credit;
    private String strCreationDate;
    private Date creationDate;
    private String accountType;
}
