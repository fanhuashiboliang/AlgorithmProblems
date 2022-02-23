package com.atguigu.stream;

import com.atguigu.OtherCharacter.java.Employee;
import com.atguigu.OtherCharacter.java.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 *
 * @author denghp
 * @create 2022-02-23 21:59
 */
public class StreamAPITest2 {

    //1-匹配与查找
    @Test
    public void test1(){

        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p)-检查是否匹配所有元素。
        //  练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);

        System.out.println(allMatch);

        System.out.println();

        //anyMatch(Predicate p)-检查是否至少匹配一个元素。
        //  练习：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(allMatch);

        System.out.println();

        //noneMatch(Predicate p)-检查是否没有匹配的元素。
        //  练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        System.out.println();

        //findFirst-返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

        System.out.println();

        //findAny-返回当前流中的任意元素
        Optional<Employee> employee1 = employees.parallelStream().findAny();
        System.out.println(employee1);

        System.out.println();

        //count-返回流中元素的总个数
        long count = employees.stream().count();
        System.out.println(count);

        System.out.println();

        //max(Comparator c)-返回流中最大值
        //  练习：返回最大的工资
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max(Double::compare);
        System.out.println(max);

        System.out.println();

        //min(Comparator c)-返回流中最小值
        //  练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

    }

    //2-归约
    @Test
    public void test2(){

        //reduce(T identity, BinaryOperator)-可以将流中元素反复结合起来，得到一个值，返回
        //  练习：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        System.out.println();

        //reduce(BinaryOperator)-可以将流中元素反复结合起来，得到一个值，返回Optional<T>
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        //Optional<Double> sumMoney = salaryStream.reduce(Double::sum);
        Optional<Double> sumMoney = salaryStream.reduce((d1,d2)->d1+d2);
        System.out.println(sumMoney);


    }

    //3.收集
    @Test
    public void test3(){

        //collect(Collector c)-将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //  练习：查找工资大于6000的员工，结果返回为一个List或Set

        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out :: println);

        System.out.println();

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out :: println);


    }

}
