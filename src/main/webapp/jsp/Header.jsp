<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MaxSeal
  Date: 2021/8/25
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--顶部-->
<div class="top">
    <div class="top_center">
        <ul class="top_bars">
            <li><a href="#">退出</a>|</li>
            <li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
            <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
            <li><a href="#">网站导航<span class="jt_down"></span></a></li>
        </ul>
    </div>
</div>
<!--头部-->
<div class="header3">
    <a href="/estore/index.jsp"><img src="images/logo.png"></a>
    <div class="h3_center">
        <div class="search_box">
            <input type="text"/>
            <span>搜索</span>
        </div>
        <p>
            <a:forEach items="${sessionScope.category}" var="entry">
                <a href="/estore/ListServlet?categoryId=${entry.key.id}">${entry.key.name}</a>|
            </a:forEach>
        </p>
    </div>
    <div class="h3_right">
        <div class="myyy">
            个人信息
            <span class="sj_down"></span>
        </div>
        <div class="tsc">
            <a href="shopCart.jsp">去购物车结算</a>
            <span class="sj_right"></span>
        </div>
    </div>
</div>

<!--头部导航-->
<div class="nav_top">
    <div class="nav_top_center">
        <div>
            全部图书分类
        </div>
        <ul>
            <a:forEach items="${sessionScope.category}" var="entry">
                <li><a href="/estore/ListServlet?categoryId=${entry.key.id}">${entry.key.name}</a></li>
            </a:forEach>
        </ul>
    </div>
</div>

