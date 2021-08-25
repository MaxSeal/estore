package com.maxseal.estore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(
        filterName = "EncodingFilter",
        urlPatterns = {"*.jsp"},
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8")},
        dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST}
)
public class EncodingFilter implements Filter {

    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取过滤器的初始化参数
        encoding = filterConfig.getInitParameter("encoding");

        // 如果 encoding 为 null, 就是设置 encoding 的值为 UTF-8
        if (encoding == null) {
            encoding = "UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {

        // 将请求和响应类型强转为 HTTP 的请求和响应类型。
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 分别给请求和响应设置字符编码
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset=UTF-8");

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

