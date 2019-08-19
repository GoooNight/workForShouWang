package com.distribution.demo.dao.mapper01;

import com.distribution.demo.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
@Mapper
public interface TeacherDAO{

    @Insert("insert into teacher(tid,tname) values(#{tid},#{tname})")
    @Options(keyColumn = "tid",useGeneratedKeys = true)
    int insert(Teacher teacher);

    @Select("select * from teacher")
    List<Teacher> selectTeacher();

}
