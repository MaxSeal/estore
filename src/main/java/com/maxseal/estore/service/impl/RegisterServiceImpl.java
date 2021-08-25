package com.maxseal.estore.service.impl;

import com.maxseal.estore.bean.Customer;
import com.maxseal.estore.dao.CustomerMapper;
import com.maxseal.estore.service.RegisterService;
import com.maxseal.estore.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class RegisterServiceImpl implements RegisterService {
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

    @Override
    public boolean judgeCustomerName(String name) {
        Customer customer = mapper.selectCustomerByName(name);
        return customer == null;
    }

    @Override
    public void register(Customer customer) {
        mapper.insert(customer);
        sqlSession.commit();
    }
}
