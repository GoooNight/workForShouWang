package com.distribution.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description mybatis绑定数据源
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
@Configuration
@MapperScan(basePackages = "com.distribution.demo.dao.mapper02",sqlSessionFactoryRef = "sqlSessionFactory2")
public class MybatisDbBConfig {
    @Autowired
    @Qualifier("dynamicDS1")
    private DataSource ds2;

    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(ds2);
        return sessionFactoryBean.getObject();
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory2());
        return sqlSessionTemplate;
    }
}
