package com.app.web;

import com.app.creanciers_service.CreancierInfo;
import com.app.creanciers_service.GetListCreanciersRequest;
import com.app.creanciers_service.GetListCreanciersResponse;
import com.app.payments_service.GetBillsRequest;
import com.app.payments_service.GetBillsResponse;
import com.app.services.BillService;
import com.app.services.CreancierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BillsController {

    @Autowired
    private BillService billService;


    @PayloadRoot(namespace = "http://app.com/payments-service",
            localPart = "getBillsRequest")
    @ResponsePayload
    public GetBillsResponse getBills(@RequestPayload GetBillsRequest request) {
        GetBillsResponse response=new GetBillsResponse();
        String creancier=request.getCreancier();
        String genericID=request.getGenericId();
        String codeCreance=request.getCodeCreance();
        response.setClientPaymntInfo(billService.getBills(creancier,genericID,codeCreance));
        return response;

    }
}
