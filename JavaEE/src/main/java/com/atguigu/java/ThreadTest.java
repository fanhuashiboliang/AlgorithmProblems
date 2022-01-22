package com.atguigu.java;

/**
 * @author denghp
 * @create 2022-01-15 15:42
 */
class Window1 extends Thread {
    private static int target = 100;

    /*@Override
    public void run(){
        while (true){
            synchronized(Window1.class){
                if(target > 0){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"卖票：票号为"+target);
                    target--;
                }else{
                    break;
                }
            }
        }
    }*/

    @Override
    public void run() {
        while (true) {
            if (target > 0) {
                sell();
            } else {
                break;
            }
        }
    }

    public static synchronized void sell() {
        if (target > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票：票号为" + target);
            target--;
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();
        w1.setName("售票员1");
        w2.setName("售票员2");
        w3.setName("售票员3");

        w1.start();
        w2.start();
        w3.start();
    }
}
