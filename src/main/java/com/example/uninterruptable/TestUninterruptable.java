package com.example.uninterruptable;


public class TestUninterruptable {

    static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("enter t1");
           synchronized (monitor) {

               try {
                   System.out.println("t1 start lock");
                   Thread.sleep(5000);
                   System.out.println("t1 end lock");
               } catch (InterruptedException e) {
                   System.out.println("t1 throw interruptException");
                   e.printStackTrace();
               }
           }
        },"t1");

        Thread t2 = new Thread(()->{
            System.out.println("enter t2");
            synchronized (monitor) {
                try {
                    System.out.println("t2 start lock");
                    Thread.sleep(1000);
                    System.out.println("t2 end lock");
                } catch (InterruptedException e) {
                    System.out.println("t2 throw interruptException");
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
        System.out.println("main end");
    }
}
