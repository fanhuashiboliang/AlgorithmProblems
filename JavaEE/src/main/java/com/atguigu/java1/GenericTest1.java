package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author denghp
 * @create 2022-02-07 21:42
 */
public class GenericTest1 {

    @Test
    public void test1(){
        //如果定义了泛型，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order<Object> order = new Order<>();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<>();
        order1.setOrderT("AAA");
    }

    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(123);

        SubOrder1<Integer> subOrder1 = new SubOrder1<>();
        subOrder1.setOrderT(123);
    }

    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;

        //list1 = list2;

    }

}
