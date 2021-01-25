package com.app.web;

import com.app.dao.CreationOpRepository;
import com.app.entity.Client;
import com.app.entity.CreationOp;
import com.app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestingController {

    @Autowired
    private CreationOpRepository creationOpRepository;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public Client save(){
        CreationOp creationOp=creationOpRepository.findAll().get(0);
        return clientService.createClient(creationOp.getClient());
    }
}
