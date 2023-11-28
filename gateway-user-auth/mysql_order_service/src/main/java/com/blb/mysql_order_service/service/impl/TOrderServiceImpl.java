package com.blb.mysql_order_service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.comment.entity.Order;
import com.blb.comment.entity.Product;
import com.blb.mysql_order_service.feign.ProductFeignClient;
import com.blb.mysql_order_service.mapper.TOrderMapper;
import com.blb.mysql_order_service.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, Order>
    implements TOrderService{

    @Autowired
    private TOrderMapper orderMapper;

    //@Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public IPage<Order> getList(int current, int size) {
        IPage<Order> list = orderMapper.getList(new Page(current, size));
        //获取分页order信息
        List<Order> order = list.getRecords();

        for (Order or:order) {
            //获取分页数据id
            Long id = or.getId();
            //根据id查询订单信息
            Order info = orderMapper.selectById(id);
            //查询订单中的商品信息
            Long productId = info.getProductId();
            //调用远程
            ResponseEntity<Product> product = productFeignClient.getProductById(productId);
            //or.setProduct(product.getBody());

        }
        return list;
    }


    @Override
    public Order getOrderById(Long id) {
        Order order = orderMapper.selectById(id);
        Long productId = order.getProductId();

        //todo haoshuhu:comment to run
        //调用远程
        //ResponseEntity<Product> product = productFeignClient.getProductById(productId);
        //order.setProduct(product.getBody());
        return order;
    }
}




