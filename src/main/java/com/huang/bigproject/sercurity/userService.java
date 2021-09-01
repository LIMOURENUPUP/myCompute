package com.huang.bigproject.sercurity;

import com.huang.bigproject.mapper.MyMapper;
import com.huang.bigproject.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:hhl
 * @DATE:2021/8/24 15:55
 */
@Component
public class userService implements UserDetailsService {
    @Autowired
    MyMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String sername) throws UsernameNotFoundException {
        user u=mapper.findByUserName(sername);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_vip1"));
        return new User(
                u.getUsername(),
                u.getPassword(),
                authorities
        );
    }
}
