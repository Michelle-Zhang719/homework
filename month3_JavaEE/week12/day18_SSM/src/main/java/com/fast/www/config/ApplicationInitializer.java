package com.fast.www.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 启动类
 *
 * @author minjie
 * @since 2023/05/17 16:27
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
//        return new String[0];
        return new String[]{"/"};
    }
}

