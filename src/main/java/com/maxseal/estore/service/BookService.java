package com.maxseal.estore.service;

import com.maxseal.estore.bean.Book;
import com.maxseal.estore.bean.Category;

import java.util.List;
import java.util.Map;

public interface BookService {
    Map<Category, List<Category>> category();
    List<Book> bookDisplay();
}
