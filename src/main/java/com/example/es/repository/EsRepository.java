package com.example.es.repository;

import com.example.es.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsRepository extends ElasticsearchRepository<Item, Long> {
}
