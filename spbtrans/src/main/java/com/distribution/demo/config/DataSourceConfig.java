package com.distribution.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description  数据源配置，包括动态数据源
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
@Configuration
public class DataSourceConfig {

    @Bean(name = "titanMasterDS")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDS1")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("titan-master", dataSource1());
        dsMap.put("ds2", dataSource2());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    @Bean("titanMasterDSManager")
    public DataSourceTransactionManager dataSourceTransactionManager01(@Qualifier("titanMasterDS")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("ds2Manager")
    public DataSourceTransactionManager dataSourceTransactionManager02(@Qualifier("ds2")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
