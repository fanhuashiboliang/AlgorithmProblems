package com.atguigu.OtherCharacter.java;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情景：当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 2.方法引用，本质上就是lambda表达式，而lambda表达式作为函数式接口的实例，所以方法引用，也是函数式接口的实例。
 *
 * 3.使用格式： 类（或对象） :: 方法名
 *
 * 4.具体分为如下的三种情况：
 *  对象 :: 非静态方法
 *  类 :: 静态方法
 *  类 :: 非静态方法
 *
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！
 *
 * @author denghp
 * @create 2022-02-21 22:23
 */
public class MethodRefTest {

    //情况一 ：对象::实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("******************");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps :: println;
        con2.accept("beijing");

    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2(){

        Employee emp = new Employee(1001, "Tom", 23, 5600);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        System.out.println("********************");
        Supplier<String> sup2 = emp ::getName;
        System.out.println(sup2.get());

    }


}
