package com.distribution.demo.controller;

import com.distribution.demo.entity.Teacher;
import com.distribution.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
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
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Transactional(transactionManager = "titanMasterDSManager",rollbackFor = Exception.class)
    @RequestMapping("addTeacher")
    public String addTeacher(Teacher teacher) throws Exception {
        int i = 0;

            i = teacherService.insert(new Teacher(20,"sda"));
            i = teacherService.insert(teacher);

            throw new Exception("");

            //设置手动回滚
            /*TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();*/
            /*return i>0?"success":"fail";*/



    }


    @RequestMapping("teacher")
    public List selectTeacher(){
        return teacherService.selectTeacher();
    }
}
