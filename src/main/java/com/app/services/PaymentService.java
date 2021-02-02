package com.app.services;

import com.app.dao.PaymentOpRespository;
import com.app.entity.Bill;
import com.app.entity.PaymentOp;
import com.app.payments_service.BillInfo;
import com.app.utils.AddCreditRequest;
import com.app.utils.ClassExchanger;
import com.app.utils.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired private PaymentOpRespository repo;
    @Autowired private AccountService accountService;
    @Autowired private AuthService authService;
    @Autowired private ClassExchanger exchanger;

    public void paymentRequest(Bill bill, String accountID, String creancier){
        String token="";
        try{
            token="Bearer "+authService.getAccessToken();
            System.out.println(accountID);
            System.out.println(bill.getAmount());
            AddCreditRequest request=new AddCreditRequest(accountID,bill.getAmount());
            accountService.addCredit(token,request);
            PaymentOp paymentOp=new PaymentOp(null,bill,accountID,creancier,"pending");
            repo.save(paymentOp);
        }
        catch(Exception e){
            System.out.println("Error auth");
        }
    }


}
