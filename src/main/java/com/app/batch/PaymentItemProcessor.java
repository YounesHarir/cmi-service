package com.app.batch;

import com.app.entity.PaymentOp;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class PaymentItemProcessor implements ItemProcessor<PaymentOp, PaymentOp> {
    @Override
    public PaymentOp process(PaymentOp paymentOp) throws Exception {
        return paymentOp;
    }
}
