package com.fast.www.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;


/**
 * Spring的配置类
 *
 * @author minjie
 * @since 2023/05/16 20:51
 */
@Configuration
@EnableTransactionManagement
//设定扫描的包目录是com.fast.www，但是需要将该目录下的Controller以及EnableWebMVc剔除掉，因为这两个注解由SpringMVC去扫描
@ComponentScan(value = "com.fast.www",excludeFilters = @ComponentScan.Filter({Controller.class, EnableWebMvc.class}))
public class SpringConfig {

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/homework?characterEncoding=utf-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    //向Spring容器中注册组件 SQLSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean;
    }

    //扫描指定的mapper包目录，将生成好的mapper实例对象放入到spring容器中
    //后续我们直接使用autowired注解既可以获取出来
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.fast.www.mapper");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return configurer;
    }

    //向Spring容器中去注册平台事务管理器，因为Spring需要依赖平台事务管理器来管理事务
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}

