package com.blb.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 广告表
 * @TableName promotion_ad
 */
@TableName(value ="promotion_ad")
@Data
public class PromotionAd implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 广告名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 广告位id
     */
    @TableField(value = "space_id")
    private Integer spaceId;

    /**
     * 精确搜索关键词
     */
    @TableField(value = "keyword")
    private String keyword;

    /**
     * 静态广告的内容
     */
    @TableField(value = "html_content")
    private String htmlContent;

    /**
     * 文字一
     */
    @TableField(value = "text")
    private String text;

    /**
     * 链接一
     */
    @TableField(value = "link")
    private String link;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "start_time")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "end_time")
    private LocalDateTime endTime;

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
    @TableField(value = "status")
    private Integer status;

    /**
     * 优先级
     */
    @TableField(value = "priority")
    private Integer priority;

    /**
     * 图片地址
     */
    @TableField(value = "img")
    private String img;

    /**
     * 逻辑删除
     */
    @TableField(value = "delete_flag")
    private String deleteFlag;

    @TableField(exist = false)
    private PromotionSpace promotionSpace;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public LocalDateTime getStartTime() {
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(startTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(format,dateTimeFormatter);
    }

    public LocalDateTime getEndTime() {
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(endTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(format,dateTimeFormatter);
    }
}