package com.macro.cloud.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.macro.cloud.domain.CommonResult;

//自定义sentine例外处理类
public class CustomBlockHandler {

    public static String handleException(BlockException exception){
        return "自定义限流信息";
    }
}
