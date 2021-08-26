package com.maxseal.estore.service;

import com.maxseal.estore.bean.Book;
import com.maxseal.estore.bean.Category;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookService {
    Map<Category, List<Category>> category();
    List<Book> bookDisplay();
    Book findBookById(int id);
    Category findCategoryById(int categoryId);
    Category findCategoryByBook(Book book);
    List<Book> findBooksByCategoryId(int categoryId);
    Set<String> publishingHouseOfBooks(List<Book> books);
}
