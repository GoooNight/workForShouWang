package com.distribution.demo.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 动态数据源注解
 * @author:awei
 * @date:2019/8/13
 * @ver:1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD
})
public @interface DS {
    String value() default "titan-master";
}
