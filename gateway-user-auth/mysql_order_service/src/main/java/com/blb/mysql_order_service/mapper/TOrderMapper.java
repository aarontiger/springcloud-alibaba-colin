package com.blb.mysql_order_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.Order;

/**
 * @Entity com.blb.mysql_order_service.entity.TOrder
 */
public interface TOrderMapper extends BaseMapper<Order> {
    IPage<Order> getList(IPage page);

}




