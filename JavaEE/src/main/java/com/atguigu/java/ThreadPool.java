package com.atguigu.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方法：使用线程池
 *
 * @author denghp
 * @create 2022-01-15 19:01
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadPool {

    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程池的属性
        //System.out.println(service.getClass());
        service1.setCorePoolSize(15);


        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口的实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());//适合适用于Runnable

        //service.submit();//适合适用于Collable

        //3.关闭连接池
        service.shutdown();
    }

}
