package com.baizhi.dao;

import com.baizhi.entity.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
@Configuration
public interface BookRepository extends ElasticsearchRepository<Book,String> {
}
