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
    @Autowired private BillService billService;

    public void paymentRequest(Bill bill, String accountID, String creancier){
        String token="";
        try{
            token="Bearer "+authService.getAccessToken();
            System.out.println(accountID);
            System.out.println(bill.getAmount());
            AddCreditRequest request=new AddCreditRequest(accountID,bill.getAmount());
            String text=accountService.addCredit(token,request);
            System.out.println(text);
            PaymentOp paymentOp=new PaymentOp(null,bill,accountID,creancier,"pending");
            repo.save(paymentOp);
            billService.batchBill(bill,creancier);
        }
        catch(Exception e){
            System.out.println("Error auth");
        }
    }


}
