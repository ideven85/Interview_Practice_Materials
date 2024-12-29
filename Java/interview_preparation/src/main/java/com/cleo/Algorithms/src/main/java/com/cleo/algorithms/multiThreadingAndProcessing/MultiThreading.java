package com.cleo.algorithms.multiThreadingAndProcessing;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreading {

    public static void calculateSquareRoot(){
        for (int i = 0; i < Integer.MAX_VALUE-1; i++) {
            System.out.print(Math.sqrt(i)+ " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Void> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                 calculateSquareRoot();
                return null;
            }
        });
        

        
    }
}
