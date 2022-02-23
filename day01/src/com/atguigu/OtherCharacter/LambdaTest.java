package com.atguigu.OtherCharacter;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author denghp
 * @create 2022-02-21 20:41
 */
public class LambdaTest {

    @Test
    public void test1(){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        runnable.run();
        System.out.println("**********************");

        Runnable r2 = () -> System.out.println("我爱北京故宫");

        r2.run();

    }

    @Test
    public void test2(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12,21);

        System.out.println(compare1);

        System.out.println("******************");

        Comparator<Integer> com2 = (Integer o1, Integer o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(23, 89);
        System.out.println(compare2);

        System.out.println("************************");

        //方法引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com3.compare(23, 12);
        System.out.println(compare3);

    }

}
