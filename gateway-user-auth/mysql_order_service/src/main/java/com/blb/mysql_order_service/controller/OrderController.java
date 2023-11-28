package com.blb.mysql_order_service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.Order;
import com.blb.mysql_order_service.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Author Charon
 * @Date 2022/8/10
 **/

@RestController
public class OrderController {

    @Autowired
    private TOrderService orderService;

    @GetMapping("/orderlist/{current}/{size}")
    public ResponseEntity<IPage<Order>> getList(@PathVariable int current, @PathVariable int size){
        return ResponseEntity.ok( orderService.getList(current,size));
    }

    //根据id查询商品信息
    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PostMapping("/order")
    public ResponseEntity<String> addProduct(Order order){
        order.setCreateTime(LocalDateTime.now());
        orderService.save(order);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/order")
    public ResponseEntity<String> updateProduct(@RequestBody Order order){
        order.setUpdateTime(LocalDateTime.now());
        orderService.updateById(order);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        orderService.removeById(id);
        return ResponseEntity.ok("ok");
    }

}
