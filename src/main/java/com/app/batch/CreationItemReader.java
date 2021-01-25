package com.app.batch;

import com.app.dao.CreationOpRepository;
import com.app.entity.CreationOp;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CreationItemReader implements ItemReader<CreationOp> {
    @Autowired
    private CreationOpRepository creationOpRepository;
    private int nextIndex;
    private List<CreationOp> clients;

    @PostConstruct
    public void init(){
        clients=creationOpRepository.findAll();
    }

    @Override
    public CreationOp read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        CreationOp client = null;
        if (nextIndex < clients.size()) {
            client = clients.get(nextIndex);
            nextIndex++;
        }
        else {
            nextIndex = 0;
        }

        return client;
    }
}
