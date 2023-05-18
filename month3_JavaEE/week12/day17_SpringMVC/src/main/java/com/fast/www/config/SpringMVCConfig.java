package com.fast.www.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author minjie
 * @since 2023/05/16 20:58
 */
@EnableWebMvc
@ComponentScan("com.fast.www.controller")
public class SpringMVCConfig {
}

