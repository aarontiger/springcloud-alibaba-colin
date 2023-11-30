package com.macro.cloud.sentinel;



import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//授权规则配置时使用,目前采用header方式，也可以采用parameter方式
@Component
public class GetParseOriginFromHeader implements RequestOriginParser {
     /**
     * 从请求头中获取origin的值,若拿到,就返回origin本身,否则返回"blanck"作为区分
     * @param request 请求对象
     * @return origin
     */
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String origin = request.getHeader("origin");
        if(StringUtils.isEmpty(origin)){
            origin = "blank";
        }
        return origin;
    }


}