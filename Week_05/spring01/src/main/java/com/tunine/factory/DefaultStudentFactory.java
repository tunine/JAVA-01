package com.tunine.factory;

import com.tunine.entity.Student;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class DefaultStudentFactory  implements  StudentFactory, InitializingBean, DisposableBean {


    // 1. 基于 @PostConstruct 注解
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : UserFactory 初始化中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("@PreDestroy : StudentFactory 销毁中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("InitializingBean#afterPropertiesSet() : StudentFactory 初始化中...");
    }

    @Override
    public Student createStudent() {
        return Student.create();
    }
}
