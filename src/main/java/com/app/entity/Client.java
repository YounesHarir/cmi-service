package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String cin;
    private String email;
    private String tel;
    private Account account;
    private Agency agency;
}
