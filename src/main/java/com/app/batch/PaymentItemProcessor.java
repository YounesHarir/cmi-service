package com.app.batch;

import com.app.entity.PaymentOp;
import org.springframework.batch.item.ItemProcessor;

public class PaymentItemProcessor implements ItemProcessor<PaymentOp, PaymentOp> {
    @Override
    public PaymentOp process(PaymentOp paymentOp) throws Exception {
        return paymentOp;
    }
}
