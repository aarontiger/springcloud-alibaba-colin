package com.blb.mysql_user_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blb.comment.entity.TUser;
import com.blb.mysql_user_service.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author Charon
 * @Date 2022/8/11
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //按用户名查询
        TUser user = userMapper.selectOne(new QueryWrapper<TUser>().lambda().eq(TUser::getUsername, s));
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        //todo haoshuhu: add password encode and login success
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String passwordEnc=bCryptPasswordEncoder.encode(user.getPassword());
        //返回正确的用户信息
        return new org.springframework.security.core.userdetails.User(s,passwordEnc,
                AuthorityUtils.commaSeparatedStringToAuthorityList(""));
    }
}
