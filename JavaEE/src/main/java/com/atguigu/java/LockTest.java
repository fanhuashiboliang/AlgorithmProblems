package com.atguigu.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author denghp
 * @create 2022-01-15 16:02
 */
class Window2 implements Runnable {

    private int target = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            //2.调用lock()
            lock.lock();
            try {

                if (target > 0) {
                    /*try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName() + "卖票：票号为" + target);
                    target--;
                } else {
                    break;
                }
            } finally {
                //3.
                lock.unlock();
            }
        }
    }
}

public class LockTest {

    public static void main(String[] args) {
        Window2 w1 = new Window2();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("售票员1");
        t2.setName("售票员2");
        t3.setName("售票员3");

        t1.start();
        t2.start();
        t3.start();
    }

}
