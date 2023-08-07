package com.yc.spring.Test5_import;

import com.yc.spring.Test2.Apple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test5.class); // 运行此代码，会把Config扫描到的bean都进行构造

        String[] names = ac.getBeanDefinitionNames(); // 取出所有bean的name
        for (String name: names){
            System.out.println(name);
        }

        Banana banana = (Banana) ac.getBean("com.yc.spring.Test5_import.Banana");
        System.out.println(banana);

        Banana banana2 = ac.getBean(Banana.class); // 用这种的话，Banana类与AppConfig_Test5就会是强依赖的类
        System.out.println(banana2);

        Apple apple = ac.getBean(Apple.class);
        System.out.println(apple);

    }
}
