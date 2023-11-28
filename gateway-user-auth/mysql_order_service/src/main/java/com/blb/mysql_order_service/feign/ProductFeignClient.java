package com.blb.mysql_order_service.feign;

import com.blb.comment.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Charon
 * @Date 2022/8/10
 **/
//@FeignClient("mysql-product-service")
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id);
}
