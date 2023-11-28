package com.blb.mysql_user_service.config;


import com.blb.comment.util.JwtUtil;
import com.blb.comment.util.ResponseResult;
import com.blb.comment.util.RsaUtil;
import com.blb.mysql_user_service.entity.UserTokenVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/11
 **/
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获得用户名
        User user = (User) authentication.getPrincipal();
        //将用户名生成jwt token
        String token = JwtUtil.generateToken(user.getUsername(), RsaUtil.privateKey, JwtUtil.EXPIRE_MINUTES);
        //将token 发送给前端
        UserTokenVO userTokenVo = new UserTokenVO(user.getUsername(),token);
        ResponseResult.write(response,ResponseResult.ok(userTokenVo));
        log.info("user:{}  token:{}",user.getUsername() , token);
    }

}
