package com.baizhi.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "dd", type = "book")  //自动创建索引dd 类型book
public class Book {
    @Id            //对应着ES文档中的ID
    private String id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;
    @Field(type = FieldType.Double)
    private Double price;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(String id, String name, Double price, String author, String content) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
