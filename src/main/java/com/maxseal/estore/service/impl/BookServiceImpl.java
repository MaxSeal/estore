package com.maxseal.estore.service.impl;

import com.maxseal.estore.bean.Book;
import com.maxseal.estore.bean.Category;
import com.maxseal.estore.dao.BookMapper;
import com.maxseal.estore.dao.CategoryMapper;
import com.maxseal.estore.service.BookService;
import com.maxseal.estore.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class BookServiceImpl implements BookService {

    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
    BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

    @Override
    public Map<Category, List<Category>> category() {
        Map<Category, List<Category>> categoryMap = new HashMap<>();
        List<Category> parentCategoryList = categoryMapper.selectAllParentCategory();

        for (Category parentCategory: parentCategoryList) {
            List<Category> childCategoryList = categoryMapper.selectAllChildCategory(parentCategory.getId());
            categoryMap.put(parentCategory, childCategoryList);
        }

        return categoryMap;
    }

    @Override
    public List<Book> bookDisplay() {
        return bookMapper.selectAllBooks();
    }

    @Override
    public Book findBookById(int id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public Category findCategoryById(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public Category findCategoryByBook(Book book) {
        return categoryMapper.selectByPrimaryKey(book.getCategoryId());
    }

    @Override
    public List<Book> findBooksByCategoryId(int categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        List<Book> bookList = new ArrayList<>();

        if (category.getParentId() == 0){
            List<Category> childCategory = categoryMapper.selectAllChildCategory(categoryId);
            for (Category c: childCategory) {
                bookList.addAll(bookMapper.selectAllBooksByCategoryId(c.getId()));
            }
            return bookList;
        } else
            return bookMapper.selectAllBooksByCategoryId(categoryId);
    }

    @Override
    public Set<String> publishingHouseOfBooks(List<Book> books) {
        Set<String> publishHouses = new HashSet<>();
        for (Book book: books) {
            publishHouses.add(book.getPublisher());
        }
        return publishHouses;
    }
}
