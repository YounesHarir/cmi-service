package com.app.services;

import com.app.entity.Account;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AccountServiceTest {
    private Account account;


    @InjectMocks
    AccountService accountService;

    @Before
    public void init(){
        Date creationDate=new Date();
        account=new Account("159","458",159,0.0,"19-7-2021",creationDate,"compte 3000");
    }
    @Test
    void addCredit() {

         account = null ;
    }

    @Test
    void payBill() {
    }
}