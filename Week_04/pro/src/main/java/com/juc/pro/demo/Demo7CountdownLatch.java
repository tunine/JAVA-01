package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Demo7CountdownLatch {

    private int value = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args)  throws InterruptedException {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Demo7CountdownLatch demo = new Demo7CountdownLatch();
        new Thread(()->{demo.sum();}).start();

        int result = demo.getValue();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private void sum(){
        value = Fibonacci.sum();
        countDownLatch.countDown();
    }

    private int getValue(){

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }
}
