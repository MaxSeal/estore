package com.maxseal.estore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(
        filterName = "LoginFilter",
        urlPatterns = {"*.jsp"}
)
public class LoginFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session = httpRequest.getSession();

        ArrayList<String> allowPathList = new ArrayList<>();
        //需要放行的页面
        allowPathList.add("/jsp/Login.jsp");
        allowPathList.add("/jsp/Register.jsp");

        String currentUrl = httpRequest.getServletPath();
        String errorMsg = "";
        if(session.getAttribute("account")==null && !allowPathList.contains(currentUrl)) {
            System.out.println(session.getAttribute("account"));
            errorMsg = "尚未登录，请先登录";
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/estore/Login.jsp").forward(request, response);
        }
        chain.doFilter(request, response);
    }
}
