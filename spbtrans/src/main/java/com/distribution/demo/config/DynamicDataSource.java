package com.distribution.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import static com.distribution.demo.config.DataSourceContextHolder.THREAD_LOCAL;

/**
 * @Description 动态数据源类
 * @author:awei
 * @date:2019/8/12
 * @ver:1.0
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return THREAD_LOCAL.get();
    }
}
