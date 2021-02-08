package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo4ReentrantLock {

    private Integer value = null;

    public Lock lock = new ReentrantLock(true);
    public Condition condition = lock.newCondition();

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Demo4ReentrantLock demo = new Demo4ReentrantLock();
        new Thread(()->{demo.sum();}).start();

        int result = demo.getValue();
        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private void sum(){
        lock.lock();
        value = Fibonacci.sum();
        //value = 0;
        condition.signal();
        lock.unlock();
    }

    private int getValue(){
        lock.lock();
        try {
            while(null == value){
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return value;
    }
}
