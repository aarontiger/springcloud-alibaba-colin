package com.atguigu.springcloud.utils;

import java.time.ZonedDateTime;

/**
 * @author Tu
 * @date 2023/8/13 18:36
 */
public class DateUtils {

    public static void main(String[] args) {
        //获取默认时区时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }

}
