package com.app.services;

import com.app.cmi_service.ClientCreationRequest;
import com.app.cmi_service.ClientInfo;
import com.app.dao.CreationOpRepository;
import com.app.entity.Account;
import com.app.entity.Agency;
import com.app.entity.Client;
import com.app.entity.CreationOp;
import com.app.utils.ClassExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreationOpService {
    @Autowired
    CreationOpRepository creationOpRepository;

    @Autowired
    ClassExchanger classExchanger;

    public void createOperation(ClientInfo clientInfo){
        Agency agency=classExchanger.generateAgency(clientInfo.getAgency());
        Account account=classExchanger.generateAccount(clientInfo.getAccount());
        Client client=classExchanger.generateClient(clientInfo,account,agency);
        CreationOp op=new CreationOp();
        op.setCreationDate(new Date());
        op.setClient(client);
        op.setStatus("pending");
        creationOpRepository.save(op);
    }

}
