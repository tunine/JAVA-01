package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.*;

public class Demo10FutureTask {

    private  static int value = 0;

    public static void main(String[] args)  throws Exception {

        long start=System.currentTimeMillis();

    /*    Callable<Integer> call = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return Fibonacci.sum();
            }
        };
*/
        FutureTask<Integer> task = new FutureTask<>(()->{
            return Fibonacci.sum();
        });
        new Thread(task).start();
        Integer result = task.get();

        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
