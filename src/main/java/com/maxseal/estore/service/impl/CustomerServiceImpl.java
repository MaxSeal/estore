package com.maxseal.estore.service.impl;

import com.maxseal.estore.bean.Customer;
import com.maxseal.estore.dao.CustomerMapper;
import com.maxseal.estore.service.CustomerService;
import com.maxseal.estore.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class CustomerServiceImpl implements CustomerService {

    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

    @Override
    public Customer judgeCustomerName(String name) {
        return mapper.selectCustomerByName(name);
    }

    @Override
    public boolean register(Customer customer) {
        Customer c = judgeCustomerName(customer.getName());
        if (c == null){
            mapper.insert(customer);
            sqlSession.commit();
            return true;
        } else
            return false;
    }
}
