package com.atguigu.OtherCharacter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>   void accept(T t)
 * 供给型接口 Supplier<T>   T get()
 * 函数型接口 Function<T,R> R apply(T t)
 * 断定型接口 Predicate<T>  boolean test(T t)
 *
 * @author denghp
 * @create 2022-02-21 21:47
 */
public class LambdaTest2 {

    @Test
    public void test1(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为："+money);
            }
        });

        System.out.println("***********************");

        happyTime(400, money -> System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为："+money));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){

        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> list1 = filterString(list, pre -> pre.contains("京"));
        System.out.println(list1);

    }

    //根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;

    }

}
