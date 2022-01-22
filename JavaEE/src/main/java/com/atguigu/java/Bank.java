package com.atguigu.java;

/**
 * @author denghp
 * @create 2022-01-15 15:27
 */

//饿汉式加载单例模式
public class Bank {

    private Bank(){

    }

    private static Bank bank = new Bank();

    public static Bank getInstance(){
        return bank;
    }

}

//线程安全的懒汉式加载单例模式
class Bank1 {

    private Bank1(){

    }

    private static Bank1 bank1 = null;

    public static Bank1 getInstance(){
        if(null == bank1) {
            synchronized (Bank1.class) {
                if (null == bank1) {
                    return new Bank1();
                }
            }
        }
        return bank1;
    }

}
