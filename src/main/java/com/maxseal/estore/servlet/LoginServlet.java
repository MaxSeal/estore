package com.maxseal.estore.servlet;

import com.maxseal.estore.bean.Customer;
import com.maxseal.estore.dao.CustomerMapper;
import com.maxseal.estore.service.LoginService;
import com.maxseal.estore.service.impl.LoginServiceImpl;
import com.maxseal.estore.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Customer customer = loginService.judgeCustomerName(name);

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
