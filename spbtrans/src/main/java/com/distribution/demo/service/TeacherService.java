package com.distribution.demo.service;

import com.distribution.demo.entity.Teacher;

import java.util.List;

/**
 * @Description
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
public interface TeacherService {

    int insert(Teacher teacher);

    List<Teacher> selectTeacher();
}
