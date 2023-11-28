package com.blb.mysql_user_service.config;

import com.blb.comment.util.ResponseResult;
import com.blb.comment.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author Charon
 * @Date 2022/8/11
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置自定义登录逻辑
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置放行url
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html","/swagger-resources/**","/webjars/**","/*/api-docs"
                        ,"/login","/logout").permitAll()
                .anyRequest().authenticated()               //配置其它url要验证
                .and()
                .formLogin()                                //配置登录相关
                .successHandler(loginSuccessHandler)  //配置登录成功的处理器
                .failureHandler((req,resp,auth) -> {        //配置登录失败的处理器
                    ResponseResult.write(resp, ResponseResult.error(ResponseStatus.LOGIN_ERROR));
                })
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((req,resp,auth) ->{ //配置拦截未登录请求的处理
                    ResponseResult.write(resp,ResponseResult.error(ResponseStatus.AUTHENTICATE_ERROR));
                })
                .and()
                .logout()
                .logoutSuccessHandler((req,resp,auth) ->{     //配置登出处理器
                    ResponseResult.write(resp,ResponseResult.ok("注销成功"));
                })
                .clearAuthentication(true)                     //清除验证缓存
                .and()
                .csrf()
                .disable()                                    //关闭csrf保护
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); //不使用session

    }
}
