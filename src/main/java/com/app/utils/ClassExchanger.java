package com.app.utils;

import com.app.cmi_service.AccountInfo;
import com.app.cmi_service.AgencyInfo;
import com.app.cmi_service.ClientInfo;
import com.app.entity.Account;
import com.app.entity.Agency;
import com.app.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClassExchanger {

    public Account generateAccount(AccountInfo accountInfo){
        Account account=new Account(null,accountInfo.getAccountNumber(),accountInfo.getAmount(),accountInfo.getCredit(),
                accountInfo.getStrCreationDate(),null,accountInfo.getAccountType());
        return account;
    }

    public Agency generateAgency(AgencyInfo agencyInfo){
        Agency agency=new Agency(null,agencyInfo.getName());
        return agency;
    }

    public Client generateClient(ClientInfo clientInfo,Account account,Agency agency){
        Client client=new Client(null,clientInfo.getFirstName(),clientInfo.getLastName(),clientInfo.getAddress(),clientInfo.getCin(),
                clientInfo.getEmail(),clientInfo.getTel(),account,agency);
        return client;
    }
}
