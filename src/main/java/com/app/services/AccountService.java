package com.app.services;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private static final String DATE_FORMAT="dd/MM/yy-HH:mm";

    /*public Account createAccount(AccountInfo accountInfo) throws Exception {
        SimpleDateFormat format=new SimpleDateFormat(DATE_FORMAT);
        Date creationDate=new Date();
        String accountNumber = UUID.randomUUID().toString().replace("-","");
        Account account = new Account(null,accountNumber, accountInfo.getAmount(), creationDate,
                creationDate.toString(), accountInfo.getClientID(), accountInfo.getAccountType());
        //Date newDate=accountInfo.getCreationDate().toGregorianCalendar().getTime();
        //account.setCreationDate(newDate);
        return accountRepository.save(account);
    }

    public AccountInfo getAccount(String accountNumber){
        Account account=accountRepository.findByAccountNumber(accountNumber);
        return setUp(account);
    }

    public AccountInfo getAccountById(String id){
        Account account=accountRepository.findById(id).orElse(null);
        return setUp(account);
    }

    public AccountInfo setUp(Account account){
        SimpleDateFormat format=new SimpleDateFormat(DATE_FORMAT);
        AccountInfo accountInfo=new AccountInfo();
        accountInfo.setAccountNumber(account.getAccountNumber());
        accountInfo.setId(account.getId());
        accountInfo.setAccountType(account.getAccountType());
        accountInfo.setAmount(account.getAmount());
        accountInfo.setClientID(account.getClientID());
        accountInfo.setStrCreationDate(format.format(account.getCreationDate()));
        return accountInfo;
    }*/
}
