package com.macro.cloud.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.macro.cloud.domain.CommonResult;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl3 {
    @SentinelResource(value="message",blockHandler = "handleException")
    public String message() {
        System.out.println("message");
        return "message";
    }

    @SentinelResource(value="message4", blockHandlerClass = CustomBlockHandler.class,blockHandler = "handleException")
    public String message4() {
        System.out.println("message4");
        return "message4";
    }

    @SentinelResource(value="message5", fallback ="fallback",blockHandler = "handleException")
    public String message5() {
//        if(true)  throw  new RuntimeException("test");//如果不配置blockHandler,会有fallback接管例外
        System.out.println("message5");
        return "message5";
    }

    public String handleException(BlockException exception){
        System.out.println("handle exep1111");
        return "bbbbb";
    }

    public String fallback(Throwable throwable) {
        return "接口发生异常了...";
    }
}
