package com.wzq.flow.service.impl;

import com.wzq.flow.dao.UserRepository;
import com.wzq.flow.pojo.User;
import com.wzq.flow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository dao;

    @Override
    public User findById(Integer userId) {
        return dao.findOne(userId);
    }
}
