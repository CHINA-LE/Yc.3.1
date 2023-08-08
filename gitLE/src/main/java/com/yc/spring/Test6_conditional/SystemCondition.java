package com.yc.spring.Test6_conditional;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SystemCondition implements Condition {

    /**
     * 匹配方法：看操作系统  <- Environment  <- spring容器
     * 这种方法一般都是 回调方法  <- 容器
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Environment:  jdk:     System.getEnv() // 环境变量里面的信息
        Environment env = context.getEnvironment();
        String osname = env.getProperty("os.name"); // 操作系统名字

        /**
         * 系统变量  os.name = windows
         * 命令参数  os.name = Linux  (如果我设置这么个命令参数会覆盖系统变量
         * 程序
         */
        System.out.println(env.getProperty("user.dir"));
        System.out.println(env.getProperty("user.home"));

        if (osname.contains("Windows")){
            return true;
        }
        return false;

    }
}
