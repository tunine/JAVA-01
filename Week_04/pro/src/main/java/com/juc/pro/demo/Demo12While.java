package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

public class Demo12While {

    private volatile Integer value = null;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Demo12While demo = new Demo12While();

        new Thread(()->{demo.sum();}).start();
        int result = demo.getValue();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private void sum(){
        value = Fibonacci.sum();
    }

    private int getValue(){
        while(true){
            if(value!=null){
                return value;
            }
        }
    }
}
