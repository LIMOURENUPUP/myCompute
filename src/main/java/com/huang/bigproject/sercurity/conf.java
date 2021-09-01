package com.huang.bigproject.sercurity;

import com.huang.bigproject.mapper.MyMapper;
import com.huang.bigproject.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author:hhl
 * @DATE:2021/8/24 15:10
 */
@EnableWebSecurity
public class conf extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Autowired
    userService service;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/add").hasRole("vip1")
                .antMatchers("/toAdd").hasRole("vip1")
                .and()
                //这个登录页面放在static目录下，不然找不到
                //当你想访问需求权限的页面时，会转去登录，登陆完了自动转到你之前想访问的页面
                .formLogin().loginPage("/login.html")
//你这里要是写了loginpage，那就会用你自己的了，不写就还是用的自带的登陆页面
//然后登录和登录处理界面后面都是直接跟文件名就行，不用跟 requestmapping里的路径。
                .and()
                .csrf().disable();
        http.logout();
    }
    @Override
    //规则设置
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(service);
//        auth.inMemoryAuthentication().withUser("hhl").password("321").roles("vip1")
//        .and().withUser("hhl2").password("321").roles("vip2");
    }

}
