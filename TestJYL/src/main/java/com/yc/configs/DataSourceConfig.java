package com.yc.configs;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@Log4j2
@Data   //lombok创建get/set
@EnableTransactionManagement //启用事物管理
public class DataSourceConfig {
    //利用DI将db.properties中的内容注入
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverclass}")
    private String driverclass;
    //以上属性db.properties中读取出来后，东欧存到spring容器的Environment的变量(系统环境变量也在这里)
    //#{T(java.lang.Math).random() * 100.0}
    @Value("#{T(Runtime).getRuntime().availableProcessors()*2}")
    //spEL -> spring expression language
    private int cpuCount;

    @Bean
    public TransactionManager dataSourceTransactionManager(@Autowired@Qualifier(value = "dataSource") DataSource ds){
        DataSourceTransactionManager tx=new DataSourceTransactionManager();
        tx.setDataSource(ds);
        return tx;
    }

    @Bean(initMethod = "init",destroyMethod = "close")//DruidDataSource中提供了  init初始化方法
    public DruidDataSource druidDataSource(){//另外要注意：idea回对这个方法的返回值进行解析，判读啊是否有init
        DruidDataSource dds=new DruidDataSource();
        dds.setUrl(url);
        dds.setDriverClassName(driverclass);
        dds.setPassword(password);
        dds.setUsername(username);
        //以上知识配置了参数，并没有创建联接池  在这个类的init()中完成联接池创建
        //当前主机的CPU数*2
        //int cpuCount=Runtime.getRuntime().availableProcessors()*2;
        log.info("配置druid联接池大小："+cpuCount);
        dds.setInitialSize(cpuCount);
        dds.setMaxActive(cpuCount*2);
        return dds;
    }

    @Bean//IOC注解 托管第三方bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        return dataSource;
    }

    @Bean
    public DataSource dbcpDataSource(){
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName(driverclass);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        //TODO:更多参数
        return dataSource;
    }
}
