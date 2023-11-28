package com.blb.mysql_order_service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.comment.entity.Order;

/**
 *
 */
public interface TOrderService extends IService<Order> {

    IPage<Order> getList(int current, int size);

    Order getOrderById(Long id);
}
