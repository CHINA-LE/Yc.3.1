package com.yc.spring.Test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 相当于一个 bean.xml配置文件
 */
@Configuration      // 此注解表示这个类是一个配置类 · 相当于 beans.xml文件
public class AppConfig {

    @Bean   // 相当于 <bean id="apple" class="com.yc.spring.Test2.Apple">
    public Apple apple(){
        Apple apple = new Apple();
        apple.setId(100);
        return apple;
    } // Apple对象以 apple 作键名，存到了 ApplicationContext容器中。

}
