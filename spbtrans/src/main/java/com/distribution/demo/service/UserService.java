package com.distribution.demo.service;

import com.distribution.demo.entity.User;

import java.util.List;

/**
 * @Description
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
public interface UserService {

    int insert(User user);

    List<User> selectUser();
}
