package com.app.batch;

import com.app.entity.CreationOp;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CreationItemProcessor implements ItemProcessor<CreationOp, CreationOp> {
    @Override
    public CreationOp process(CreationOp creationOp) throws Exception {
        return creationOp;
    }
}
