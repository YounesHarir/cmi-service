package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ClientPayment {
    private Long id;
    private String idPayment;
    private String fixeNumber;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private List<Bill> bills;
}
