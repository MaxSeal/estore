package com.maxseal.estore.servlet;

import com.maxseal.estore.bean.Customer;
import com.maxseal.estore.service.CustomerService;
import com.maxseal.estore.service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/jsp/Register.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String zipCode = request.getParameter("zipCode");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");

        Customer customer = new Customer(name, password, zipCode, address, telephone, email);
        if (customerService.register(customer)) {
            writer.write("success");
        } else
            writer.write("false");
    }
}
