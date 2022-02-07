package com.atguigu.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author denghp
 * @create 2022-01-22 19:21
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
