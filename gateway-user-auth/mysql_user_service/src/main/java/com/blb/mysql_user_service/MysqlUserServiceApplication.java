package com.blb.mysql_user_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@MapperScan("com.blb.mysql_user_service.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class MysqlUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlUserServiceApplication.class, args);
    }

}
