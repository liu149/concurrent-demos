package com.example.semaphore;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
    static int COUNT = 10;
    static Semaphore semaphore = new Semaphore(20);
    static Object monitor = new Object();

    public static void copy(int count) {
        try{
            semaphore.acquire();
            int i = 10/0;
        }catch (Exception e) {
            count++;
            if(count < COUNT) {
                copy(count);
            }
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        copy(0);
        System.out.println(semaphore.availablePermits());


    }
}
