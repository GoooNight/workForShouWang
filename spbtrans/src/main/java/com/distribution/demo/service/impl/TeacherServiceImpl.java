package com.distribution.demo.service.impl;

import com.distribution.demo.dao.mapper01.TeacherDAO;
import com.distribution.demo.entity.Teacher;
import com.distribution.demo.service.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDAO teacherDAO;

    @Override
    public int insert(Teacher teacher) {
        return teacherDAO.insert(teacher);
    }

    @Override
    public List<Teacher> selectTeacher() {
        return teacherDAO.selectTeacher();
    }
}
