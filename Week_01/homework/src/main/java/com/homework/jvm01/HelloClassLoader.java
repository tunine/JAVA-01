package com.homework.jvm01;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class cs = new HelloClassLoader().findClass("Hello");
            Method method = cs.getMethod("hello");
            Object obj = cs.newInstance();
            method.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getCurrentPath()+name+".xlass";
        byte[] bytes = getFileBytes(fileName);
        bytes = decode(bytes);
        return defineClass(name,bytes,0,bytes.length);
    }


    /**
     * 读取文件到byte[]
     * @param fileName
     * @return
     */
    private static byte[] getFileBytes(String fileName) {
        try {
            File f = new File(fileName);
            int length = (int) f.length();
            byte[] data = new byte[length];
            new FileInputStream(f).read(data);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 处理字节255-x
     * @param bytes
     */
    private static byte[] decode(byte[] bytes){
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return  bytes;
    }

    /**
     * 获取当前路径
     * @return
     */
    public String getCurrentPath() {
        String dirPath = this.getClass().getResource("/").getPath();
        System.out.println(dirPath);
        return dirPath;
    }
}
