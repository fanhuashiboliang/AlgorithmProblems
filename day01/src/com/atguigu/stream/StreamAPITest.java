package com.atguigu.stream;

import com.atguigu.OtherCharacter.java.Employee;
import com.atguigu.OtherCharacter.java.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author denghp
 * @create 2022-02-22 21:21
 */
public class StreamAPITest {

    //创建Stream方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream= employees.parallelStream();

    }

    //创建Stream方式二： 通过数组
    @Test
    public void test2(){
        int[] arr = {1,2,3,4,5,6};
        //调用Arrays类的static <T> Stream<T> stream(T[] array) : 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");

        Employee[] employees = {e1, e2};

        Stream<Employee> stream1 = Arrays.stream(employees);


    }

    //创建 Stream方式三 ： 通过Stream的of()
    @Test
    public void test3(){

        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建 Stream 方式四 ： 创建无限流
    @Test
    public void test4(){

        //迭代
        Stream.iterate(0, t->t+2).limit(10).forEach(System.out :: println);

        //生成
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);



    }

}
