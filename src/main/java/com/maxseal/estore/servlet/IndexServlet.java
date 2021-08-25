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
import java.util.Map;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "index.jsp";
        HttpSession session = request.getSession();

        Map<Category, List<Category>> categoryListMap = bookService.category();
        List<Book> bookList = bookService.bookDisplay();

        session.setAttribute("category", categoryListMap);
        session.setAttribute("books", bookList);

        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
