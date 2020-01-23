package com.example.es;

import com.example.es.entity.Item;
import com.example.es.repository.EsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;

@SpringBootTest
public class EsDemoApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private EsRepository esRepository;


    @Test
    public void CreateIndex() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.putMapping(Item.class);
    }

    /**
     * 删除数据库
     */
    @Test
    public void testDeleteIndex() {
        elasticsearchTemplate.deleteIndex(Item.class);
    }
    @Test
    public void testSaveItemList() {
        Item item2 = new Item(10L, "华为手机nate20Pro", "手机", "华为", 699.0, "https://img10.360buyimg.com/cms/jfs/t28402/77/271791263/9559/3c4ae8ad/5bf80a4eN1a99b125.jpg");
        Item item3 = new Item(21L, "iphone x", "手机", "苹果", 799.0, "https://img10.360buyimg.com/cms/jfs/t28402/77/271791263/9559/3c4ae8ad/5bf80a4eN1a99b125.jpg");
        Item item4 = new Item(32L, "iphone xs", "手机", "苹果", 899.0, "https://img10.360buyimg.com/cms/jfs/t28402/77/271791263/9559/3c4ae8ad/5bf80a4eN1a99b125.jpg");
        Item item5 = new Item(43L, "iphone xs Max", "手机", "苹果", 999.0, "https://img10.360buyimg.com/cms/jfs/t28402/77/271791263/9559/3c4ae8ad/5bf80a4eN1a99b125.jpg");

        ArrayList<Item> list = new ArrayList<>();
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);

        esRepository.saveAll(list);
    }


}
