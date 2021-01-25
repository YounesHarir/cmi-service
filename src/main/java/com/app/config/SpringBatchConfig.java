package com.app.config;

import com.app.entity.CreationOp;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.HashMap;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    //@Autowired private MongoTemplate mongoTemplate;
    @Autowired private JobBuilderFactory jobBuilderFactory;
    @Autowired private StepBuilderFactory stepBuilderFactory;
    @Autowired private ItemReader<CreationOp> itemReader;
    @Autowired private ItemWriter<CreationOp> itemWriter;
    @Autowired private ItemProcessor<CreationOp,CreationOp> itemProcessor;

    @Bean
    public Job clientCreationJob(){
        Step step1=stepBuilderFactory.get("step-load-data")
                .<CreationOp,CreationOp>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("client-creator-job").start(step1).build();
    }

    /*public MongoItemReader<CreationOp> mongoItemReader() {
        MongoItemReader<CreationOp> reader=new MongoItemReader<>();
        reader.setTemplate(mongoTemplate);
        reader.setTargetType(CreationOp.class);
        reader.setQuery("{status:\"pending\"}");
        return reader;
    }*/
}
