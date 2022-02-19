package com.atguigu.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;


/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author denghp
 * @create 2022-02-19 12:02
 */
public class NewInstanceTest {

    @Test
    public void  test1() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class<Person> clazz = Person.class;

        /*
        newInstance()：调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参构造器。

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够，通常，设置为public。


        在javabean中要求提供一个public的空参构造器，原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

         */
        Person person = clazz.newInstance();

        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Person tome = constructor.newInstance("Tome", 6);
        System.out.println(tome);

        System.out.println(person);

    }

    //体会反射的动态性
    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        int num = new Random().nextInt(3);//0,1,2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.atguigu.reflection.Person";
                break;
        }
        Object obj = getInstance(classPath);
        System.out.println(obj);

    }

    /*
    创建一个指定类的对象
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
