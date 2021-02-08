package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Demo13ForkJoinTask {

    private  static int value = 0;

    public static void main(String[] args)  throws Exception {

        long start=System.currentTimeMillis();


        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> future = forkJoinPool.submit(()->{
            return Fibonacci.sum();
        });
        int result = future.get();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
