package com.app.services;

import com.app.entity.ClientPayment;
import com.app.entity.Form;
import com.app.payments_service.ClientPaymentInfo;
import com.app.payments_service.FormInfo;
import com.app.utils.ClassExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.datatype.DatatypeConfigurationException;

@Service
public class BillService {

    @Autowired
    public RestTemplate restTemplate;

    @Value("${gateway-service}")
    private String url;

    @Autowired
    private ClassExchanger classExchanger;

    public ClientPaymentInfo getBills(String creancier,String genericID,String codeCreance) throws DatatypeConfigurationException {
        RestTemplate restTemplate=new RestTemplate();
        ClientPayment info=restTemplate.getForObject(url+creancier+"/payment/"+genericID+"/"+codeCreance,ClientPayment.class);
        return classExchanger.generateClientPaymentInfo(info);
    }
}
