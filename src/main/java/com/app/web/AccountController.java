package com.app.web;

import com.app.entity.Account;
import com.app.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountController {

    /*@PayloadRoot(namespace = "http://app.com/cmi-service",
            localPart = "createAccountRequest")
    @ResponsePayload
    public CreateAccountResponse createAccount(@RequestPayload CreateAccountRequest request) throws Exception {
        Account created=accountService.createAccount(request.getAccountInfo());
        CreateAccountResponse response=new CreateAccountResponse();
        request.getAccountInfo().setId(created.getId());
        request.getAccountInfo().setAccountNumber(created.getAccountNumber());
        response.setAccountInfo(request.getAccountInfo());
        return response;
    }

    @PayloadRoot(namespace = "http://app.com/cmi-service",
            localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) throws Exception {
        GetAccountResponse response=new GetAccountResponse();
        response.setAccountInfo(accountService.getAccount(request.getAccountNumber()));
        return response;
    }

    @PayloadRoot(namespace = "http://app.com/cmi-service",
            localPart = "getAccountByIdRequest")
    @ResponsePayload
    public GetAccountByIdResponse getAccountById(@RequestPayload GetAccountByIdRequest request) throws Exception {
        GetAccountByIdResponse response=new GetAccountByIdResponse();
        response.setAccountInfo(accountService.getAccountById(request.getId()));
        return response;
    }*/
}
