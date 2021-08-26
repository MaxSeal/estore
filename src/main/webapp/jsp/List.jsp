<%--
  Created by IntelliJ IDEA.
  User: MaxSeal
  Date: 2021/8/25
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>briup电子商务-首页</title>
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/icons.css" />
    <link rel="stylesheet" href="css/table.css" />
</head>
<body>
<%@ include file="Header.jsp" %>
<!--内容-->
<div class="container4">
    <!--热卖-->
    <div class="c4_b1">
        <ul class="c4_b1_boxes">
            <a:forEach items="${sessionScope.books}" var="book" begin="0" end="3">
            <li>
                <img src="${book.image}">
                <div class="c4_b1_box_txt">
                    <p>${book.name} </p>
                    <h1>活动价：<b>￥${book.price}</b></h1>
                    <h2><a href="/estore/ViewBookServlet?bookId=${book.id}">立即抢购</a></h2>
                </div>
            </li>
            </a:forEach>
        </ul>
    </div>
    <div class="c4_b2">
        <h1 class="c4_b2_x">
            <a href="#">书籍&nbsp;&nbsp;></a>
            <span><a href="#">${requestScope.category.name}</a></span>
        </h1>

<%-- 动态添加的标签 --%>
<%--        <ul class="c4_b2_y">--%>
<%--            <li>--%>
<%--                <span class="search_key">价格：</span>--%>
<%--                <span class="search_val">0-99</span>--%>
<%--                <span class="search_del"></span>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <span class="search_key">出版社：</span>--%>
<%--                <span class="search_val">清华出版社</span>--%>
<%--                <span class="search_del"></span>--%>
<%--            </li>--%>
<%--        </ul>--%>
    </div>
    <div class="c4_b3">
        <h1></h1>
        <div>
            <ul class="c4_b3_search">
                <li class="c4_b3_name">价格：</li>
                <li class="c4_b3_vals">
                    <a href="#">20以下</a>
                    <a href="#">20-40</a>
                    <a href="#">40-60</a>
                    <a href="#">60-80</a>
                    <a href="#">80-100</a>
                    <a href="#">100以上</a>
                </li>
            </ul><ul class="c4_b3_search">
            <li class="c4_b3_name">出版社：</li>
            <li class="c4_b3_vals">
                <a:forEach items="${requestScope.publishingHouses}" var="publishingHouse">
                    <a href="#">${publishingHouse}</a>
                </a:forEach>
            </li>
        </ul>
        </div>
    </div>
    <div class="c4_b4">
        <div class="c4_b4_x">
            <ul class="c4_b4_nav">
                <li class="current"><a href="#">默认</a></li>
                <li><a href="#">销量</a></li>
                <li><a href="#">价格</a></li>
                <li><a href="#">新品</a></li>
            </ul>
            <div class="c4_b4_search">
                <input type="text"/><span>确认</span>
            </div>
            <div class="c4_b4_pages">

            </div>
            <div class="clear"></div>
        </div>
        <div class="c4_b4_y">
            <ul>
                <li><input type="checkbox">仅显示有货</li>
            </ul>
        </div>
    </div>
    <!--商品列表-->
    <div class="c4_b5">
        <div class="c4_b5_content">
            <ul class="c4_b5_c_boxes">
                <a:forEach items="${requestScope.booksByCategory}" var="book">
                <li class="c4_b5_c_box">
                    <!--图片-->
                    <div class="c4_b5_c_box_pic">
                        <div class="c4b5_pic_view">
                            <a href="/estore/ViewBookServlet?bookId=${book.id}"><img src="${book.image}"></a>
                        </div>
                    </div>
                    <!--价钱-->
                    <div class="c4_b5_c_box_txt">
                        <h1>￥ ${book.price}</h1>
                        <h2><a href="/estore/ViewBookServlet?bookId=${book.id}">${book.name}</a></h2>
                    </div>
                    <!--购买等操作-->
                    <div class="c4b5_el">
                        <div class="c4b5_el_x">
                            <span class="wjx01"></span>
                        </div>
                    </div>
                    <ul class="c4b5_option">
                        <li class="shopcar_box">
                            <span class="shopcar01"></span>
                            <a href="#">加入购物车</a>
                        </li>
                    </ul>
                </li>
                </a:forEach>
            </ul>
        </div>
    </div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>