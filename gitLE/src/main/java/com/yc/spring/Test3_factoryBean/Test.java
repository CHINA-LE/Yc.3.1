package com.yc.spring.Test3_factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试  FactoryBean的使用
 */
public class Test {
    public static void main(String[] args) {
        // 1.创建容器
        //  容器启动： FruitFactoryBean  Pear    看这两个对象的构造 --> 只有FruitFactoryBean被构造了
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest3.class);

        Object obj1 = ac.getBean("ffb"); // beanId = ffb --> Pear产品对象
        System.out.println(obj1.hashCode());

        Object obj2 = ac.getBean("&ffb"); // beanId = &ffb --> 工厂bean
        System.out.println(obj2);

        // 2.pear是单例 or 多例
        obj1 = ac.getBean("ffb"); // beanId = &ffb --> 工厂bean
        System.out.println(obj1.hashCode());

        // 3. 获取 spring容器中所有托管的Bean的name:
        String[] beanName = ac.getBeanDefinitionNames();
        for (String bn: beanName){
            System.out.println(bn);
        }
    }
}
