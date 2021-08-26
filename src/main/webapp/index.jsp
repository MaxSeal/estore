<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.maxseal.estore.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>briup电子商务-首页</title>
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/icons.css"/>
    <link rel="stylesheet" href="css/table.css"/>
    <link rel="stylesheet" type="text/css" href="css/turn.css">

</head>
<body>
<%@ include file="jsp/Header.jsp" %>
<div class="container3">
    <div class="c3_b1">
        <div class="c3_b1_left">
            <dl>
                <a:forEach items="${sessionScope.category}" var="entry">
                    <dd>
                        <h1>${entry.key.name}</h1>
                        <p>
                            <b:forEach items="${sessionScope.category.get(entry.key)}" var="childCategory">
                                <a href="/estore/ListServlet?categoryId=${childCategory.id}">${childCategory.name}</a>
                            </b:forEach>
                        </p>
                    </dd>
                </a:forEach>
            </dl>
        </div>

        <div class="c3_b1_center">
            <!-- 图片伦伯 -->
            <div class="carousel" id="carousel">
                <div class="btns">
                    <a href="javascript:;" class="leftBtn" id="leftBtn"></a>
                    <a href="javascript:;" class="rightBtn" id="rightBtn"></a>
                </div>
                <div class="m_unit" id="m_unit">
                    <ul>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                        <li><a href="#"><img src="images/ad1.png" alt=""/></a></li>
                    </ul>
                </div>
                <div class="circles" id="circles">
                    <ol>
                        <li class="cur"></li>
                        <li></li>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ol>
                </div>
            </div>

            <div class="c3_b1_c_bottom">
                <ul>
                    <a:forEach items="${sessionScope.books}" var="book" begin="0" end="2">
                        <li>
                            <a href="/estore/ViewBookServlet?bookId=${book.id}"><img src="${book.image}" alt=""/></a>
                            <a href="/estore/ViewBookServlet?bookId=${book.id}">${book.name}</a>
                        </li>
                    </a:forEach>
                </ul>
            </div>
        </div>

        <div class="c3_b1_right">
            <h1>杰普快报<a href="#">更多</a></h1>
            <ul>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
                <li><a href="#">〈加措〉虾哥牛逼 </a></li>
            </ul>
        </div>
        <div style="clear:both"></div>

    </div>
    <div class="c3_b2">
        <ul>
            <c:forEach items="${sessionScope.books}" var="book">
                <li>
                    <div class="c3_b2_txt">
                        <h1>${book.name}</h1>
                        <p>${book.price}元</p>
                        <h2>畅销书籍</h2>
                        <h2>${book.description}</h2>
                        <p><a href="/estore/ViewBookServlet?bookId=${book.id}">更多精彩，点击进入</a></p>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<div class="c20"></div>
<%@ include file="jsp/Footer.jsp" %>
<script type="text/javascript" src="js/animate-2.0.1.js"></script>
<script type="text/javascript" src="js/turn.js"></script>
</body>
</html>
