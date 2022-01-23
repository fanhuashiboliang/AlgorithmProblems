package com.atguigu.java;

/**
 * @author denghp
 * @create 2022-01-22 19:21
 */
public @interface MyAnnotation {

    String value() default "hello";
}
