package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Demo8CyclicBarrier {

    private  static int value = 0;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Demo8CyclicBarrier demo = new Demo8CyclicBarrier();

        CyclicBarrier barrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                value = Fibonacci.sum();
                System.out.println("value:"+value);
            }
        });
        int result = demo.getValue(barrier);
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private int getValue(CyclicBarrier barrier ){
        try {
            System.out.println(1);
            barrier.await();
            System.out.println(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        return value;
    }
}
