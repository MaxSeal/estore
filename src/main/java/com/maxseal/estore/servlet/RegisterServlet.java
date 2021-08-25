package com.maxseal.estore.servlet;

import com.maxseal.estore.bean.Customer;
import com.maxseal.estore.dao.CustomerMapper;
import com.maxseal.estore.service.RegisterService;
import com.maxseal.estore.service.impl.RegisterServiceImpl;
import com.maxseal.estore.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    RegisterService registerService = new RegisterServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        if (registerService.judgeCustomerName(name)) {
            Customer customer = new Customer(name, password, zipCode, address, telephone, email);
            registerService.register(customer);
            writer.write("success");
        } else
            writer.write("false");
    }
}
