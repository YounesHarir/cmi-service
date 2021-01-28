package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Document(collection = "creances")
public class Creance {
    private String id;
    private String nameCreance;
    private String codeCreance;
    private String endPoint;
}
