package com.maxseal.estore.servlet;

import com.maxseal.estore.bean.Customer;
import com.maxseal.estore.service.CustomerService;
import com.maxseal.estore.service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Customer customer = customerService.judgeCustomerName(name);

        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();

        if (customer == null){
            writer.write("this account is illegal");
        } else {
            if (customer.getPassword().equals(password)){
                session.setAttribute("account", name);
                writer.write("success");
            } else {
                writer.write("password is wrong");
            }
        }
    }
}
