package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.locks.LockSupport;

public class Demo5LockSupport {

    private static  int  value = 0;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Thread main = Thread.currentThread();
        Demo5LockSupport demo = new Demo5LockSupport();
        Thread t = new Thread(()->{
            value = Fibonacci.sum();
            //System.out.println(value);
            LockSupport.unpark(main);
        });
        t.start();
        LockSupport.park();

        int result = value;
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
