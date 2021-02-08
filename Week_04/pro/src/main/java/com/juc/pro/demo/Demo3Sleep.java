package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.TimeUnit;

public class Demo3Sleep {

    private static int value = 0;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        new Thread(()->{value = Fibonacci.sum();}).start();
        try {
            // sleep 100ms 确保拿到了数据
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = value;
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
