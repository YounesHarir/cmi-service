package com.app.services;

import com.app.creanciers_service.CreancierInfo;
import com.app.dao.CreancierRepository;
import com.app.entity.Creancier;
import com.app.utils.ClassExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreancierService {
    @Autowired
    private CreancierRepository creancierRepository;

    @Autowired
    private ClassExchanger classExchanger;

    public List<CreancierInfo> getCreanciers(){
        List<Creancier> creanciers=creancierRepository.findAll();
        List<CreancierInfo> creancierInfos=new ArrayList<>();
        for(Creancier creancier:creanciers){
            creancierInfos.add(classExchanger.generateCreancierInfo(creancier));
        }
        return creancierInfos;
    }

}
