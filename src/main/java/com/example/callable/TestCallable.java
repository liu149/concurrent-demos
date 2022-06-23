package com.example.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        FutureTask<String> futureTask = new FutureTask(task);
        new Thread(futureTask).start();

        String result = futureTask.get();
        System.out.println(result);

    }


    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello world";
        }
    }
}
