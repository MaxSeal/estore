package com.maxseal.estore.service;

import com.maxseal.estore.bean.Customer;

public interface RegisterService {
    boolean judgeCustomerName(String name);
    void register(Customer customer);
}
