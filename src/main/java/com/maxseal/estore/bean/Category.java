package com.maxseal.estore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private Integer parentId;

    private static final long serialVersionUID = 1L;

    public Category(String name, String description, Integer parentId) {
        this.name = name;
        this.description = description;
        this.parentId = parentId;
    }
}