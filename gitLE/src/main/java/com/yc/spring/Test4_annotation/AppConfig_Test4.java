package com.yc.spring.Test4_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.yc.spring.Test4_annotation") // 指定spring容器扫描的路径
public class AppConfig_Test4 {
    // @Bean // 原来是利用@Bean来创建Bean，交给spring托管；现在直接用@ComponentScan指定路径自动扫描添加了
    // @Bean 一般用于引入第三方的bean
    // @ComponentScan 用于自己写的bean（自动扫描

    // @Component 是通用的，一般用于你不知道这是什么层的时候进行使用，知道了就要替换成相应的
    // @Service  用于业务层
    // @Repository 用于dao层
    // @Controller 用于控制层
}
