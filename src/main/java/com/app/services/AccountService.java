package com.app.services;

import com.app.utils.AddCreditRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service",url = "")
public interface AccountService {
    @PostMapping("/payment/addCredit")
    public String addCredit(@RequestBody AddCreditRequest addCreditRequest);
}
