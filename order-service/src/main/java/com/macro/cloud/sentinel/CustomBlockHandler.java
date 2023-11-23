package com.macro.cloud.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.macro.cloud.domain.CommonResult;

/**
 * Created by macro on 2019/11/7.
 */
public class CustomBlockHandler {

    public static String handleException(BlockException exception){
        return "自定义限流信息";
    }
}
