package com.atguigu.reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * @author denghp
 * @create 2022-02-18 21:22
 */
public class ReflectionTest {

    //疑问：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
    //建议：直接new的方式。
    //什么时候会使用 反射的方式，反射的特征：动态性
    //疑问：反射机制与面向对象的封装性是不是矛盾的？如何看待两个技术？
    //不矛盾。

    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件（.class结尾），接着我们使用
    java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程
    就称为类的加载。记载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。

    3.加载到内存中的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式来获取次运行时类。

     */
    //获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test1() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：通过Class的静态方法：forName(String classPath)
        Class<?> clazz3 = Class.forName("com.atguigu.reflection.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1==clazz3);

        //方式四：使用类的加载器：ClassLoader (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.atguigu.reflection.Person");
        System.out.println(clazz1 == clazz4);

    }

    @Test
    public void test2(){

        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[]> c4 = int[].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class<? extends int[]> c10 = a.getClass();
        Class<? extends int[]> c11 = b.getClass();
        //只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }

}
