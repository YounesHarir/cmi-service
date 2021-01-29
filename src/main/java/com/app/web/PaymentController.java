package com.app.web;

import com.app.cmi_service.ClientCreationRequest;
import com.app.cmi_service.ClientCreationResponse;
import com.app.payments_service.GetFormsRequest;
import com.app.payments_service.GetFormsResponse;
import com.app.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentController {

    @Autowired
    private FormService formService;

    @PayloadRoot(namespace = "http://app.com/payments-service",
            localPart = "getFormsRequest")
    @ResponsePayload
    public GetFormsResponse createAccount(@RequestPayload GetFormsRequest request) {
        GetFormsResponse response=new GetFormsResponse();
        response.setForm(formService.getForm(request.getCodeCreance(),request.getCreance()));
        return response;
    }
}
