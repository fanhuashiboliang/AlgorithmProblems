package com.atguigu.java;

/**
 * @author denghp
 * @create 2022-01-15 9:39
 */
class Window implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                show();
            } else {
                break;
            }

        }
    }

    private synchronized void show() {
        if (ticket > 0) {
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println(Thread.currentThread().getName() + ": 售票，票号为" + ticket);
            ticket--;
        }
    }

}

public class RunnableTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
