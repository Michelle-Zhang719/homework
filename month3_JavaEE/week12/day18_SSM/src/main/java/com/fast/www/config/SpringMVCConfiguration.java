package com.fast.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc配置类
 * @author minjie
 * @since 2023/05/17 16:50
 */
@EnableWebMvc
@ComponentScan("com.fast.www.controller")
public class SpringMVCConfiguration implements WebMvcConfigurer {

    //在容器中注册MultipartResolver组件（但是组件的id必须是multipartResolver，否则无法处理）
    @Bean
    public MultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }
}

