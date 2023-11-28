package com.blb.mysql_order_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Charon
 * @Date 2022/8/12
 **/
@RestController
@RefreshScope
public class ConfigController {
    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/order/config")
    public String config(){
        return driverName + " " + url;
    }

}
