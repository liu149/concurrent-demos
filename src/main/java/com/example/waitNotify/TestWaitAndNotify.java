package com.example.waitNotify;

/**
 * 通过wait和notify实现两个线程1-100轮流打印
 */
public class TestWaitAndNotify {

    static int num = 1;
    static Object monitor = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            synchronized (monitor) {

                while(num < 100) {
                    if(num % 2 == 0) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "--------->" + num++);
                    monitor.notify();
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (monitor) {
                while(num < 100) {
                    if(num % 2 != 0) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "--------->" + num++);
                    monitor.notify();
                }
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
