package com.maxseal.estore.servlet;

import com.maxseal.estore.bean.Book;
import com.maxseal.estore.bean.Category;
import com.maxseal.estore.service.BookService;
import com.maxseal.estore.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "jsp/List.jsp";
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = bookService.findCategoryById(categoryId);
        List<Book> booksByCategory = bookService.findBooksByCategoryId(categoryId);
        Set<String> publishingHouses = bookService.publishingHouseOfBooks(booksByCategory);

        request.setAttribute("category", category);
        request.setAttribute("booksByCategory", booksByCategory);
        request.setAttribute("publishingHouses", publishingHouses);
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
