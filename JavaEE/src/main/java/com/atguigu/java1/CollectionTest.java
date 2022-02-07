package com.atguigu.java1;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi,数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      >一旦初始化以后，其长度就确定了。
 *      >数组一旦定义好，其元素的类型就确定了，也就只能操作指定类型的数据，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *          比如：String[] arr;int[] arr1;
 *      >获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      >数组存储数据的特点：有序、可重复，对于无序、不可重复的需求，不能满足。
 *
 *二、集合框架
 *      |----Collection接口：单列集合，用于存储一个一个的对象
 *          |----List接口：存储有序的，可重复的数据。    --->"动态"数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据    --->高中讲的"集合"
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对（key-value）的数据    --->高中函数：y=f(x)
 *          |----HashMap、linkedHashMap、TreeMap、Hashtable、Properties
 *
 *  Collection接口中声明的方法的测试
 *
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在的类要重新equals();
 *
 *
 *
 * @author denghp
 * @create 2022-01-23 17:39
 */
public class CollectionTest {

    public static void main(String[] args) {
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        Properties properties = new Properties();
        Collection objects = new ArrayList<>();
        System.out.println(objects.isEmpty());
        objects.add(123);
        System.out.println(objects.isEmpty());
        objects.clear();
        System.out.println(objects.isEmpty());
    }

    @Test
    public void test1(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        person p = new person("小明", 28);
        coll.add(p);
        //contains(Object obj)：判断当前集合是否包含obj
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(p));
        System.out.println(coll.contains(new person("小明", 28)));


        //2.containsAll(Collection coll1):判断形参coll1的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2(){
        //3.remove(Object obj):从当前集合中移除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        person p = new person("小明", 28);
        coll.add(p);

        coll.remove(123);
        System.out.println(coll);
        coll.remove(new person("小明", 28));
        System.out.println(coll);

        //4.removeAll(Collection coll1):从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        person p = new person("小明", 28);
        coll.add(p);

        //retainAll(Conllection coll1):获取当前集合和coll1集合的交集，并返回当前集合
        /*Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);*/

        //equals(Object obj):
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);

        coll1.add(new String("Tom"));
        coll1.add(false);
        person p1 = new person("小明", 28);
        coll1.add(new person("小明", 28));

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        person p = new person("小明", 28);
        coll.add(p);

        //7.hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合---->数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public  void test5(){
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

    }

    @Test
    public void test6(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);

        coll.forEach(System.out::println);

    }

    @Test
    public void test7(){
        HashSet hashSet = new HashSet();
        person p1 = new person("小米", 20);
        person p2 = new person("小蓝",18);
        hashSet.add(p1);
        hashSet.add(p2);

        p1.setAge(21);
        hashSet.remove(p1);
        System.out.println(hashSet);

        hashSet.add(new person("小米",20));
        System.out.println(hashSet);
        hashSet.add(new person("小米",21));
        System.out.println(hashSet);

    }
}

class person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals()............");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
