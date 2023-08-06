package com.yc.spring.Test6_conditional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_test6.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name: names){
            System.out.println(name);
        }
    }
}
