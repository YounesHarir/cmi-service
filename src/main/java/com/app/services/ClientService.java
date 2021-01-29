package com.app.services;

import com.app.entity.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "client-service",url = "http://ensaspay-client-service.herokuapp.com/api/client")
public interface ClientService {
    @PostMapping("/create")
    public Client createClient(@RequestBody Client client);

    @GetMapping("/cmi/{tel}")
    public Client cmiChecker(@PathVariable String tel);
}
