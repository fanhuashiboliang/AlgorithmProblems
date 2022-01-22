package com.atguigu.java;

/**
 * 继承thread
 * @author denghp
 * @create 2022-01-15 8:47
 */
class Clerk{
    private int num = 0;
    public synchronized void produceProduct() {
        if(num < 20) {
            num++;
            System.out.println(Thread.currentThread().getName() + "正在生产第" + num + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumProduct() {
        if(num > 0) {
            System.out.println(Thread.currentThread().getName() + "正在消费第" + num + "个产品");
            num--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumProduct();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.setName("生产者一");
        thread2.setName("消费者一");
        thread1.start();
        thread2.start();
    }
}
