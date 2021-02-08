package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.*;

public class Demo9Future {

    private  static int value = 0;

    public static void main(String[] args)  throws Exception {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        ExecutorService executor
                = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            int result = Fibonacci.sum();
            return result;
        });
        int result =  future.get();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
