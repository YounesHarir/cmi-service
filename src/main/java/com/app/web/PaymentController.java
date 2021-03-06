package com.app.web;

import com.app.cmi_service.ClientCreationRequest;
import com.app.cmi_service.ClientCreationResponse;
import com.app.entity.Bill;
import com.app.payments_service.GetFormsRequest;
import com.app.payments_service.GetFormsResponse;
import com.app.payments_service.PaymentRequest;
import com.app.payments_service.PaymentResponse;
import com.app.services.BillService;
import com.app.services.FormService;
import com.app.services.PaymentService;
import com.app.utils.ClassExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class PaymentController {

    @Autowired private FormService formService;
    @Autowired private PaymentService paymentService;
    @Autowired private BillService billService;

    @PayloadRoot(namespace = "http://app.com/payments-service",
            localPart = "getFormsRequest")
    @ResponsePayload
    public GetFormsResponse getForm(@RequestPayload GetFormsRequest request) {
        GetFormsResponse response=new GetFormsResponse();
        response.setForm(formService.getForm(request.getCodeCreance(),request.getCreance()));
        return response;
    }

    @PayloadRoot(namespace = "http://app.com/payments-service",
            localPart = "paymentRequest")
    @ResponsePayload
    public PaymentResponse payBill(@RequestPayload PaymentRequest request) throws DatatypeConfigurationException {
        PaymentResponse response=new PaymentResponse();
        Bill bill = billService.getBill(request.getCreancier(),request.getBillID());
        paymentService.paymentRequest(bill,request.getAccountID(),request.getCreancier());
        response.setResponse("Request waiting for approval");
        return response;
    }
}
