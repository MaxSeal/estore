<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册</title>
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/style.css" />
    <script src="../js/jquery-1.12.3.min.js" type="text/javascript"></script>
    <script src="../js/Register.js" type="text/javascript"></script>
</head>

<body>
<div class="container2">
    <div class="header2">

        <div>
            <a href="#"><img class="logo" src="../images/logon_register.png" alt=""></a>
        </div>

        <div>
            <ul class="tabs">
                <li class="phone current"><a href="#">用户注册，请将信息填写完整</a></li>
            </ul>
        </div>

        <div class="tlg">
            已有账号 <a href="Login.jsp">登录</a>
        </div>

    </div>

    <div class="content2">

        <form method="post">
            <ul class="reg_box">
                <li>
                    <label>
                        <span><b>*</b>用户名：</span>
                        <input type="text" name="name" required/>
                    </label>
                </li>
                <li>
                    <label>
                        <span><b>*</b>密码：</span>
                        <input type="password" name="password" required/>
                    </label>
                </li>
                <li>
                    <label>
                        <span><b>*</b>邮编：</span>
                        <input type="text" name="zipCode" required/>
                    </label>
                </li>
                <li>
                    <label>
                        <span><b>*</b>地址：</span>
                        <input type="text" name="address" required/>
                    </label>
                </li>
                <li>
                    <label>
                        <span><b>*</b>电话：</span>
                        <input type="tel" name="telephone" required/>
                    </label>
                </li>
                <li>
                    <label>
                        <span><b>*</b>电子邮箱：</span>
                        <input type="email" name="email" required/>
                    </label>
                </li>
            </ul>

            <p>
                <label>
                    <input type="checkbox" required/>
                    我已阅读并同意
                    <a href="#">用户注册协议</a>
                </label>
            </p>
            <input class="btn_submit" type="submit" value="立即注册"/>
        </form>

    </div>
</div>
</body>
</html>
