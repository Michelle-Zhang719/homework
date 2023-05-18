package com.fast.www.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 启动类
 * 配置Spring的配置类；
 * 配置SpringMVC配置类
 * @author minjie
 * @since 2023/05/16 20:47
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    /**
     * 提供Spring的配置类，service以及mapper以及其他的一些组件交给Spring去处理
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 提供SpringMVC配置类，controller相关全部交给SpringMVC去处理
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    /**
     * 设置SpringMVC核心控制器DispatcherServlet的url-pattern为/
     * 此处可不可以设置/*?   /index.jsp    tomcat中存在一个servlet叫做JspServlet url-pattern为 *.jsp
     * 看你需求，如果你希望显示jsp页面，那么不要设置/*，如果你对此不要求，那么/*也可以
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

