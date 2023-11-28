package com.blb.mysql_order_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients("com.blb.mysql_order_service.feign")
@SpringBootApplication
@MapperScan("com.blb.mysql_order_service.mapper")
public class MysqlOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlOrderServiceApplication.class, args);
    }

}
