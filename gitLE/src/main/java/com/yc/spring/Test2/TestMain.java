package com.yc.spring.Test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // AnnotationConfigApplicationContext -> 基于注释@Configuration的配置类
        // 到这里 IOC完成，DI也完成了
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Apple apple = (Apple) ac.getBean("apple");
        System.out.println(apple);
    }
}
