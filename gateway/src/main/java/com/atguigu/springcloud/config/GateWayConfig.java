package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用编码方式实现gateway网关配置
 *
 * @author Tu
 * @date 2023/8/13 16:55
 */
@Configuration
public class GateWayConfig {

    /**
     * 通过编码方式路由器访问百度网站：http://zhidao.baidu.com
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        //相当于配置文件方式的 routes
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //连续点多个方法叫做：链式调用
        //route中的id相当于配置中的id，path为断言(路由匹配)，uri为路径
        //断言表示，访问http://localhost:9527/guonei，符合条件的请求，会uri + 断言拼接路径并调用
        routes.route("path_route_atguigu", e -> e.path("/question/656403371411523645")
                .uri("http://zhidao.baidu.com")).build();
        //这里还可以设置多个route，和上述一样，但是要确保id不重复
        return routes.build();
    }

}
