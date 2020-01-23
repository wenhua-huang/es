package com.example.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "item", type = "item", shards = 1, replicas = 0)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item  {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Text)
    private String category;

    @Field(type = FieldType.Text)
    private String brand;

    @Field(type = FieldType.Text)
    private Double price;

    @Field(type = FieldType.Text, index = false)
    private String images;
}
