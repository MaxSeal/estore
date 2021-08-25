package com.maxseal.estore.service;

import com.maxseal.estore.bean.Customer;

public interface LoginService {
    Customer judgeCustomerName(String name);
}
