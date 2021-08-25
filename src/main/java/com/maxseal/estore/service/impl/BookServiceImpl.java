package com.maxseal.estore.service.impl;

import com.maxseal.estore.bean.Book;
import com.maxseal.estore.bean.Category;
import com.maxseal.estore.dao.BookMapper;
import com.maxseal.estore.dao.CategoryMapper;
import com.maxseal.estore.service.BookService;
import com.maxseal.estore.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
