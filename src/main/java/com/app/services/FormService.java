package com.app.services;

import com.app.entity.Form;
import com.app.payments_service.FormInfo;
import com.app.utils.ClassExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FormService {

    @Autowired
    public RestTemplate restTemplate;

    @Value("${gateway-service}")
    private String url;

    @Autowired
    private ClassExchanger classExchanger;

    public FormInfo getForm(String codeCreance, String creancier){
        RestTemplate restTemplate=new RestTemplate();
        Form form=restTemplate.getForObject(url+creancier+"/form/"+codeCreance,Form.class);
        return classExchanger.generateFormInfo(form);
    }
}
