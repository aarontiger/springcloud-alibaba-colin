package com.macro.cloud.sentinel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController3 {


    @Autowired
    private OrderServiceImpl3 orderServiceImpl3;


    @RequestMapping("/order/message1") public String message1() {
        return orderServiceImpl3.message();
    }


    @RequestMapping("/order/message2") public String message2() {
    orderServiceImpl3.message(); return "message2";
    }

    int i = 0;
    @RequestMapping("/order/message3")
    public String message3() {
        i++;
//异常比例为0.333
        if (i % 3 == 0){
            throw new RuntimeException();
        }
        return "message3";
    }

    //测试blockHandlerClass
    @RequestMapping("/order/message4")
    public String message4() {
        return orderServiceImpl3.message4();
    }

    //测试FallbackHandler
    @RequestMapping("/order/message5")
    public String message5() {
        return orderServiceImpl3.message5();
    }


}
