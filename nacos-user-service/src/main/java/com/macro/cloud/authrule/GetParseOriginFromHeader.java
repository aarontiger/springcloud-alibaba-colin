package com.macro.cloud.authrule;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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