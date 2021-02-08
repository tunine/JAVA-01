package com.juc.pro.common;

/**
 * 斐波那契数列
 */
public class Fibonacci {

    public static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
