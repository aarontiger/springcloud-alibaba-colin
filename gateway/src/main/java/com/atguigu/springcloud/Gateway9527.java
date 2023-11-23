package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Tu
 * @date 2023/8/13 15:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Gateway9527 {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9527.class, args);
    }

}
