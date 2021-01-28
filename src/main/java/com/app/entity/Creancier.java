package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Document(collection = "creanciers")
public class Creancier {
    private String id;
    private String nameCreancier;
    private String codeCreancier;
    private String categoryCreancier;
    private List<Creance> listCreances;
}
