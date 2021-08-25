package com.maxseal.estore.service;

import com.maxseal.estore.bean.Customer;

public interface CustomerService {
    Customer judgeCustomerName(String name);
    boolean register(Customer customer);
}
