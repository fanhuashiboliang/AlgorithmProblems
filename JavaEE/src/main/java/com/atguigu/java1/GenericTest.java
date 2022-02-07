package com.atguigu.java1;

import org.junit.Test;

import java.util.*;
import java.util.Map.*;


/**
 * 泛型的使用
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *  总结：
 *  ①集合接口或者集合类在jdk5.0时都修改为带泛型的结构。
 *  ②在实例化集合类时，可以指明具体的泛型类型
 *  ③指明完以后，在集合类或者接口中凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型
 *      比如：add(E e)   ----> 实例化后  add(Integer e)
 *  ④注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  ⑤如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 *
 *
 * @author denghp
 * @create 2022-02-07 20:55
 */
public class GenericTest {

    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        //问题一：类型不安全
        //list.add("Tom");
        for (Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        //编译时，就会进行类型检查，保证数据的安全
        //list.add("Tom");
        //方式一
        /*for (Integer score:list) {
            //避免强转报错
            System.out.println(score);
        }*/

        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer score = iterator.next();
            System.out.println(score);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom",98);
        map.put("Jerry",100);
        map.put("Jeck",87);

        //泛型的嵌套
        Set<Entry<String, Integer>> entries = map.entrySet();
        Iterator<Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+"---"+next.getValue());
        }
    }

}