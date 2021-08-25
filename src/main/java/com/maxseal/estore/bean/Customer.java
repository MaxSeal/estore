package com.maxseal.estore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer implements Serializable {
    private Integer id;

    private String name;  // 用户名

    private String password;  // 密码

    private String zipcode;  // 邮政编码

    private String address;  // 地址

    private String telephone;  // 联系电话

    private String email;  // 邮箱

    private static final long serialVersionUID = 1L;

    public Customer(String name, String password, String zipcode, String address, String telephone, String email) {
        this.name = name;
        this.password = password;
        this.zipcode = zipcode;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }
}