package com.atguigu.java;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @author denghp
 * @create 2022-01-23 16:03
 */
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotations {
    MyAnnotation[] value();
}
