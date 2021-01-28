package com.app.web;

import com.app.cmi_service.ClientCreationRequest;
import com.app.cmi_service.ClientCreationResponse;
import com.app.creanciers_service.CreancierInfo;
import com.app.creanciers_service.GetListCreanciersRequest;
import com.app.creanciers_service.GetListCreanciersResponse;
import com.app.services.CreancierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CreancierController {

    @Autowired
    private CreancierService creancierService;


    @PayloadRoot(namespace = "http://app.com/creanciers-service",
            localPart = "getListCreanciersRequest")
    @ResponsePayload
    public GetListCreanciersResponse getCreanciers(@RequestPayload GetListCreanciersRequest request) {
        GetListCreanciersResponse response=new GetListCreanciersResponse();
        for(CreancierInfo creancierInfo:creancierService.getCreanciers()){
            response.getListCreanciers().add(creancierInfo);
        }
        return response;

    }
}
