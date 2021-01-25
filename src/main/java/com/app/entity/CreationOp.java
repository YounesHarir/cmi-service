package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Document(collection = "creationOps")
public class CreationOp {
    private String id;
    private Date creationDate;
    private Client client;
    private String status;
}
