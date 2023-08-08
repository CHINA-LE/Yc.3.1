package com.yc.spring.Test5_import;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration          // Pear的托管                  Grape的托管(注：只有Pear被托管了，Grape才会被托管)
@Import({Banana.class, FruitImportSelector.class, FruitNameImportBeanDefinitionRegistrar.class})
public class AppConfig_3 {
    // 去掉FruitImportSelector.class也就是不托管Pear了，Grape也不会被托管

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_3.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name: names){
            System.out.println(name);
        }

    }
}
