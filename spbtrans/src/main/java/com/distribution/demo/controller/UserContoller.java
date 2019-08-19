package com.distribution.demo.controller;

import com.distribution.demo.config.DS;
import com.distribution.demo.entity.Teacher;
import com.distribution.demo.entity.User;
import com.distribution.demo.service.TeacherService;
import com.distribution.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
@RestController
public class UserContoller {
    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;


    @Transactional(transactionManager = "titanMasterDSManager")
    @RequestMapping("addUser")
    public String addUser(User user){
        int i;
        try {
             i = userService.insert(user);
        }catch (Exception e){
            throw e;
        }
        return i>0?"success":"fail";
    }

    @RequestMapping("user")
    @DS("ds2")
    public List selectUser(){
        return userService.selectUser();
    }
}
