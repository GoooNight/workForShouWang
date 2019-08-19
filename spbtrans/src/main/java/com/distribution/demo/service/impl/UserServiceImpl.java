package com.distribution.demo.service.impl;

import com.distribution.demo.dao.mapper02.UserDAO;
import com.distribution.demo.entity.User;
import com.distribution.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public List<User> selectUser() {
        return userDAO.selectUser();
    }
}
