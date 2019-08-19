package com.distribution.demo.config;

/**
 * @Description 动态数据源的设置类
 * @author:awei
 * @date:2019/8/13
 * @ver:1.0
 **/
public class DataSourceContextHolder {
    public static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal();

    public static void setDB(String dbType){
        THREAD_LOCAL.set(dbType);
    }
    public static String getDB(){
        return THREAD_LOCAL.get();
    }
    public static void clearDB() {
        THREAD_LOCAL.remove();
    }
}
