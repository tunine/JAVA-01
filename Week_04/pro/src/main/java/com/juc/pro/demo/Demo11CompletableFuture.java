package com.juc.pro.demo;

import com.juc.pro.common.Fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

public class Demo11CompletableFuture {

    private  static int value = 0;

    public static void main(String[] args)  throws Exception {

        long start=System.currentTimeMillis();


        // 方法一
       /* CompletableFuture<Integer> future = new CompletableFuture<>();

        new Thread(()->{
            future.complete(Fibonacci.sum());
        }).start();
        Integer result = future.get();*/

       // 方法二
        //Integer result = CompletableFuture.supplyAsync(() ->Fibonacci.sum()).join();

        // 方法三
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return Fibonacci.sum();
        });
        int result = future.get();

        // thenApply
       /* CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()->{
            return 5;
        }).thenApply((r)->{
            r = r + 1;
            System.out.println(r);
            return r;
        });
        System.out.println(future1.get());*/

        // allOf
       /* long start1 = System.currentTimeMillis();
        Demo11CompletableFuture test = new Demo11CompletableFuture();
        // 结果集
        List<String> list = new ArrayList<>();*/

       /* List<Integer> taskList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 全流式处理转换成CompletableFuture[]
        CompletableFuture[] cfs = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> test.calc(integer))
                        .thenApply(h->Integer.toString(h))
                        .whenComplete((s, e) -> {
                            System.out.println("任务"+s+"完成!result="+s+"，异常 e="+e+","+new Date());
                            list.add(s);
                        })
                ).toArray(CompletableFuture[]::new);

        System.out.println(CompletableFuture.allOf(cfs).join());

        System.out.println("list="+list+",耗时="+(System.currentTimeMillis()-start1));*/

        // 确保拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    public int calc(Integer i) {
        try {
            if (i == 1) {
                Thread.sleep(3000);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(5000);//任务5耗时5秒
            } else {
                Thread.sleep(1000);//其它任务耗时1秒
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }
}
