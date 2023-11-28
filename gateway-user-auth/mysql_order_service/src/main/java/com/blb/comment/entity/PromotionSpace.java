package com.blb.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 广告区域表
 * @TableName promotion_space
 */
@TableName(value ="promotion_space")
@Data
public class PromotionSpace implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 广告位key
     */
    @TableField(value = "space_key")
    private String spaceKey;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 
     */
    @TableField(value = "is_del")
    private Integer isDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}