package com.app.web;

import com.app.cmi_service.ClientCreationRequest;
import com.app.cmi_service.ClientCreationResponse;
import com.app.services.CreationOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CreationOpController{

    @Autowired
    CreationOpService creationOpService;

    @PayloadRoot(namespace = "http://app.com/cmi-service",
            localPart = "clientCreationRequest")
    @ResponsePayload
    public ClientCreationResponse createAccount(@RequestPayload ClientCreationRequest request) {
        System.out.println("tesssting");
        creationOpService.createOperation(request.getClientInfo());
        ClientCreationResponse response=new ClientCreationResponse();
        response.setResponse("Request is saved we will be in touch later");
        return response;
    }

}
