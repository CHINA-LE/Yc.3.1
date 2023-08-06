package com.yc.spring.Test5_import;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 需求：根据条件（是否已经加载好了Pear），判断是否加载 Grape到容器 · 并指定名字（beanId）
 *
 * 此技术所解决的问题是
 * 1. 假设你要使用mybatis -> SessionFactory -> Session 这个会话是要联接数据库的。
 *      如果使用数据库联接池，在联接池没有建立的情况下mybatis是无法使用的，所以要判断联接池是否建立，然后再建立会话工厂（SessionFactory）
 * 2. beanId过于冗长（一般是使用@Import，其约定使用全路径名为beanId）
 */
public class FruitNameImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public FruitNameImportBeanDefinitionRegistrar() {
        System.out.println("FruitNameImportBeanDefinitionRegistrar被构造了！！！");
    }

    /**
     *
     * @param importingClassMetadata ： 当前扫描的注解
     * @param registry ： 已经注册好的bean的容器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 先判断是否已经有了 Pear 加载到容器
        boolean bean = registry.containsBeanDefinition("com.yc.spring.Test3_factoryBean.Pear");
        // 如果有，则再创建Grape Bean加载到容器内
        if (bean){
            RootBeanDefinition d = new RootBeanDefinition(Grape.class);
            // 并指定键为 grape
            registry.registerBeanDefinition("grape", d);
        }
    }


}
