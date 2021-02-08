package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

class Demo1Synchronized {

    private int value = 0;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Demo1Synchronized demo= new Demo1Synchronized();

        new Thread(() -> {
            demo.sum();
        }).start();
        int result = demo.getValue();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private synchronized void sum(){
        value = Fibonacci.sum();
        this.notifyAll();
    }

    /**
     *
     */
    private synchronized int getValue(){
        try {
           this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

}