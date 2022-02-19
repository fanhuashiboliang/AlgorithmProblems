package com.atguigu.reflection2;


import com.atguigu.reflection1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 *
 * @author denghp
 * @create 2022-02-19 16:54
 */
public class FieldTest {

    @Test
    public void test1(){

        Class<Person> clazz = Person.class;

        //获取属性结构
        //getFields()：获取当前运行时类及其父类中声明为Public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        System.out.println();

        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] fields1 = clazz.getDeclaredFields();
        for(Field f : fields1){
            System.out.println(f);
        }

    }

    //权限修饰符 数据类型 变量名
    @Test
    public void test2(){

        Class<Person> clazz = Person.class;
        Field[] fields1 = clazz.getDeclaredFields();
        for(Field f : fields1){
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(modifiers);
            System.out.println(Modifier.toString(modifiers));
            //2.数据类型
            Class<?> type = f.getType();
            System.out.println(type.getName() + "\t");
            //3.变量名
            String name = f.getName();
            System.out.println(name);

            System.out.println(f);
            System.out.println("-----------");
        }

    }

}
