package com.macro.cloud.sentinel;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//低版本SCA流控规则-链路模式需要的配置类
//使用SCA升级后到高版本后，不需要此配置类，需要在yml中修改配置

@Configuration
public class FilterContextConfig {

//    @Bean
//    public FilterRegistrationBean sentinelFilterRegistration() { FilterRegistrationBean registration = new FilterRegistrationBean(); registration.setFilter(new CommonFilter()); registration.addUrlPatterns("/*");
//// 入口资源关闭聚合
//        registration.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
//        registration.setName("sentinelFilter");
//        registration.setOrder(1); return registration;
//    }
}

