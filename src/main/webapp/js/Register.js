$(function () {
    let form = $('form')[0];
    $(form).on('submit', function (event) {
        event.preventDefault(); // 阻止默认的提交表单行为

        let name = form.name.value;
        let password = form.password.value;
        let zipCode = form.zipCode.value;
        let address = form.address.value;
        let telephone = form.telephone.value;
        let email = form.email.value;

        $.post(
            "/estore/RegisterServlet",
            {name, password, zipCode, address, telephone, email},
            function (result) {
                if (result === "success") {
                    alert("注册成功");
                    window.location.href = "http://localhost:8080/estore/jsp/Login.jsp";
                } else if (result === "false") {
                    alert("用户名已存在");
                }
            },
            "text"
        );
    });
});