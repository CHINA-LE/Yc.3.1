package com.yc.spring.Test5_import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 表示这个相当于 bean
@Import({Banana.class, FruitImportSelector.class}) // 也可以直接写成 Banana.class这样的
public class AppConfig_2 {
    // @Import里面虽然有FruitImportSelector但注入到容器的bean不是它，而是FruitImportSelector里所传入的类的全路径名
}
