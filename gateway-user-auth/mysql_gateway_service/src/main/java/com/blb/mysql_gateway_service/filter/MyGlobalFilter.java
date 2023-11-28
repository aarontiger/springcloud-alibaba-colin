package com.blb.mysql_gateway_service.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author Charon
 * @Date 2022/8/11
 **/
@Slf4j
//@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获得请求和响应对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //获得请求参数
        String token = request.getQueryParams().getFirst("token");
        if(token != null && "1234".equals(token)){
            //参数符合要求，放行
            return chain.filter(exchange);
        }else {
            //参数不符合要求，返回验证失败的响应信息
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            DataBuffer wrap = response.bufferFactory().wrap("验证失败，token参数错误".getBytes());
            return  response.writeWith(Mono.just(wrap));
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
