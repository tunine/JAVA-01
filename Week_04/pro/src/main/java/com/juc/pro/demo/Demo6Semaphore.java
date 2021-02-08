package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.Semaphore;

public class Demo6Semaphore {

    private int value = 0;

    private final static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args)  throws InterruptedException {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        semaphore.acquire();
        Demo6Semaphore demo = new Demo6Semaphore();
        new Thread(()->{demo.sum();}).start();

        int result = demo.getValue();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private void sum(){
        try {
            value = Fibonacci.sum();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    private int getValue(){
        try {
            int a = 1;
            semaphore.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return value;
    }
}
