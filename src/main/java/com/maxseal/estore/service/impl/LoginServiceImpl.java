package com.maxseal.estore.service.impl;

import com.maxseal.estore.bean.Customer;
import com.maxseal.estore.dao.CustomerMapper;
import com.maxseal.estore.service.LoginService;
import com.maxseal.estore.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class LoginServiceImpl implements LoginService {
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();

    @Override
    public Customer judgeCustomerName(String name) {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        return mapper.selectCustomerByName(name);
    }
}
