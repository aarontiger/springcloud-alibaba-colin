package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 设置gateway过滤器，如果是多个，可以形成过滤链
 *
 * @author Tu
 * @date 2023/8/13 19:33
 */
@Slf4j
//@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*****gateway全局过滤器*****");
        //先获取请求中的用户名称
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (StringUtils.isEmpty(username)) {
            log.info("不符合请求规范，名称不能为空！");
            //优化返回响应
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //响应，如果有多个过滤器，会进入下一个，所有过滤器走完都通过才算成功
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
