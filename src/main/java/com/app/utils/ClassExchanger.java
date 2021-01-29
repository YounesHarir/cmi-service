package com.app.utils;

import com.app.cmi_service.AccountInfo;
import com.app.cmi_service.AgencyInfo;
import com.app.cmi_service.AgentInfo;
import com.app.cmi_service.ClientInfo;
import com.app.creanciers_service.CreanceInfo;
import com.app.creanciers_service.CreancierInfo;
import com.app.entity.*;
import com.app.payments_service.FormInfo;
import org.springframework.stereotype.Component;


@Component
public class ClassExchanger {

    public Account generateAccount(AccountInfo accountInfo){
        Account account=new Account(null,accountInfo.getAccountNumber(),accountInfo.getAmount(),accountInfo.getCredit(),
                accountInfo.getStrCreationDate(),null,accountInfo.getAccountType());
        return account;
    }

    public Agency generateAgency(AgencyInfo agencyInfo){
        Agency agency=new Agency(agencyInfo.getId(),agencyInfo.getName(),agencyInfo.getAddress());
        return agency;
    }

    public Agent generateAgent(AgentInfo agentInfo){
        Agent agent=new Agent(agentInfo.getId(),agentInfo.getFirstName(),agentInfo.getLastName(),agentInfo.getPhoneNumber(),agentInfo.getIdentityNumber()
                ,agentInfo.getPatenteNumber(),agentInfo.getEmail(),generateAgency(agentInfo.getAgency()));

        return agent;
    }

    public Client generateClient(ClientInfo clientInfo,Account account,Agent agent){
        Client client=new Client(null,clientInfo.getFirstName(),clientInfo.getLastName(),clientInfo.getAddress(),clientInfo.getCin(),
                clientInfo.getEmail(),clientInfo.getTel(),account,agent);
        return client;
    }

    public CreanceInfo generateCreanceInfo(Creance creance){
        CreanceInfo creanceInfo=new CreanceInfo();
        creanceInfo.setCodeCreance(creance.getCodeCreance());
        creanceInfo.setEndPoint(creance.getEndPoint());
        creanceInfo.setId(creance.getId());
        creanceInfo.setNameCreance(creance.getNameCreance());

        return creanceInfo;
    }

    public CreancierInfo generateCreancierInfo(Creancier creancier){
        CreancierInfo creancierInfo=new CreancierInfo();
        creancierInfo.setCategoryCreancier(creancier.getCategoryCreancier());
        creancierInfo.setCodeCreancier(creancier.getCodeCreancier());
        creancierInfo.setId(creancier.getId());
        creancierInfo.setNameCreancier(creancier.getNameCreancier());
        for(Creance creance:creancier.getListCreances()){
            creancierInfo.getListCreances().add(generateCreanceInfo(creance));
        }

        return creancierInfo;
    }

    public FormInfo generateFormInfo(Form form){
        FormInfo formInfo=new FormInfo();
        formInfo.setId(form.getId());
        formInfo.setLabel(form.getLabel());
        formInfo.setCodeCreance(form.getCodeCreance());
        return formInfo;
    }
}
