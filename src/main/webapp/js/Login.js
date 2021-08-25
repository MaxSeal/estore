$(function () {
    let form = $('form')[0];
    $(form).on('submit', function (event) {
        event.preventDefault(); // 阻止默认的提交表单行为

        let name = form.name.value;
        let password = form.password.value;

        $.post("/estore/LoginServlet",
            {name, password},
            function (result) {
                if(result === "this account is illegal"){
                    alert("用户名错误或不存在")
                } else if (result === "password is wrong"){
                    alert("密码错误");
                } else if (result === "success"){
                   location.href = "http://localhost:8080/estore/index.jsp";
                }
            }, "text"
        );
    });
});