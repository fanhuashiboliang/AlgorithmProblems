package com.atguigu.stream;

import com.atguigu.OtherCharacter.java.Employee;
import com.atguigu.OtherCharacter.java.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author denghp
 * @create 2022-02-22 22:05
 */
public class StreamAPITest1 {

    //1-筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        //filter(Predicate p)——接收 Lambda，从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary()>7000).forEach(System.out :: println);

        System.out.println();

        //limit(n)——截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out :: println);

        System.out.println();

        //skip(n)——跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足 n 个，则返回一个空流，与 limit(n) 互补
        list.stream().skip(3).forEach(System.out :: println);

        System.out.println();

        //distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 41, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));

        list.stream().distinct().forEach(System.out :: println);
    }

    //2.映射
    @Test
    public void test2(){
        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out :: println);

        System.out.println();

        //练习：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee :: getName).filter(name -> name.length()>3).forEach(System.out :: println);

        System.out.println();

        //flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后吧所有流连接成一个流。
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out :: println));

        System.out.println();

        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out :: println);

    }

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    //3——排序
    @Test
    public void test3(){
        //sorted() ——自然排序
        List<Integer> list = Arrays.asList(12, 21, 32, 24, 54, 65, 0, -12, -19);
        list.stream().sorted().forEach(System.out :: println);

        System.out.println();

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted().forEach(System.out :: println);

        System.out.println();

        //sorted(Comparator aom)——定制排序
        employees.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out :: println);

    }

}
