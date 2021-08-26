package com.maxseal.estore.servlet;

import com.maxseal.estore.bean.Book;
import com.maxseal.estore.bean.Category;
import com.maxseal.estore.service.BookService;
import com.maxseal.estore.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewBookServlet", value = "/ViewBookServlet")
public class ViewBookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "jsp/ViewBook.jsp";
        String bookId = request.getParameter("bookId");

        Book book = bookService.findBookById(Integer.parseInt(bookId));
        Category category = bookService.findCategoryByBook(book);
        request.setAttribute("book", book);
        request.setAttribute("category", category);
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
