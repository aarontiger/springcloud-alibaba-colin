package com.blb.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName t_product
 */
@TableName(value ="t_product")
@Data
public class Product implements Serializable {
    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 商品价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 逻辑删除
     */
    @TableField(value = "delete_flag")
    private String deleteFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}