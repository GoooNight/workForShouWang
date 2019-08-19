package com.distribution.demo.dao.mapper02;


import com.distribution.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @Description
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
@Mapper
public interface UserDAO {

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int insert(User user);

    @Select("select * from user")
    List<User> selectUser();
}
