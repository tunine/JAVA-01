package com.tunine;

import com.tunine.entity.Student;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanDefinitionDemo {

    public static void main(String[] args) {

        //BeanFactory context = new  ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");

        Student student01 = (Student) context.getBean("student-by-setter-injection");
        System.out.println(student01.toString());

        Student student11 = (Student) context.getBean("student-by-constructor-injection");
        System.out.println(student11.toString());

        Student student02 = (Student) context.getBean("student-by-static-method");
        System.out.println(student02.toString());

        Student student03 = (Student)context.getBean("student-by-factory-bean");
        System.out.println(student03.toString());

        Student student04 = (Student)context.getBean("student-by-instance-method");
        System.out.println(student04.toString());


        Student studenttest = (Student) context.getBean("student01");
        System.out.println("studenttest=" +studenttest.toString());

        Student studenttest1 = (Student) context.getBean("student02");
        System.out.println("studenttest1=" +studenttest1.toString());

        Student studenttest3 = (Student) context.getBean("student03");
        System.out.println("studenttest3=" +studenttest3.toString());

        //((ClassPathXmlApplicationContext) context).destroy();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
