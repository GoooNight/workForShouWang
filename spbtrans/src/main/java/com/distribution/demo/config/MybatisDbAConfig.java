package com.distribution.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description mybatis绑定数据源
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
@Configuration
@MapperScan(basePackages = "com.distribution.demo.dao.mapper01",sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisDbAConfig {

    @Resource(name = "titanMasterDS")
    private DataSource ds1;

    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(ds1);
        return sessionFactoryBean.getObject();
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory1());
        return sqlSessionTemplate;
    }


}
