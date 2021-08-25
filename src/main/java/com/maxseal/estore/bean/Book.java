package com.maxseal.estore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book implements Serializable {
    private Integer id;

    private String name;

    private Double price;

    private String author;

    private String publisher;

    private Date pubdate;

    private String description;

    private Integer categoryId;

    private String image;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Book(String name, Double price, String author, String publisher, Date pubdate, String description, Integer categoryId, String image) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.pubdate = pubdate;
        this.description = description;
        this.categoryId = categoryId;
        this.image = image;
    }
}