package com.app.batch;

import com.app.dao.PaymentOpRespository;
import com.app.entity.PaymentOp;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public class PaymentItemReader implements ItemReader<PaymentOp> {
    @Autowired
    private PaymentOpRespository paymentOpRespository;
    private int nextIndex;
    private List<PaymentOp> payments;

    @PostConstruct
    public void init(){
        payments=paymentOpRespository.findAll();
    }

    @Override
    public PaymentOp read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        PaymentOp payment = null;
        if (nextIndex < payments.size()) {
            payment = payments.get(nextIndex);
            nextIndex++;
        }
        else {
            nextIndex = 0;
        }

        return payment;
    }
}
