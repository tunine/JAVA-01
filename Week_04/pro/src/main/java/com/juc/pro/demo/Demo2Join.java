package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

public class Demo2Join {

    private int value = 0;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Demo2Join demo = new Demo2Join();
        try {
            Thread t = new Thread(()->{demo.sum();});
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result = demo.getValue();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private void sum(){
        value = Fibonacci.sum();
    }

    private int getValue(){
        return value;
    }
}
