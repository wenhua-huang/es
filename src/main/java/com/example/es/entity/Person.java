package com.example.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "marvel", type = "characters")
public class Person {
    private @Id  Long id;
    private String name;
    private int age;
}
