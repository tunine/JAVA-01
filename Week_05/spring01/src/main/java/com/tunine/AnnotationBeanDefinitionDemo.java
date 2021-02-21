package com.tunine;

import com.tunine.entity.Student;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class（配置类）
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        registerUserBeanDefinition(applicationContext,"tunine-student");
        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 按照类型依赖查找
        System.out.println("Config 类型的所有 Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("Student 类型的所有 Beans" + applicationContext.getBeansOfType(Student.class));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();


    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(Student.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 12001)
                .addPropertyValue("name", "nunine21");

        // 判断如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }


    // 2. 通过 @Component 方式
    @Component // 定义当前类作为 Spring Bean（组件）
    public static class Config {

        // 1. 通过 @Bean 方式定义

        /**
         * 通过 Java 注解的方式，定义了一个 Bean
         */
        @Bean(name = {"user", "tunine-student1"})
        public Student student() {
            Student student = new Student();
            student.setId(12002);
            student.setName("tunine22");
            return student;
        }
    }

}
