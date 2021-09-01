package com.huang.bigproject.controller;

import com.huang.bigproject.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:hhl
 * @DATE:2021/8/23 20:55
 */
@Controller
public class loginController {
    @Autowired
    MyMapper mapper;

    //这两个是自己写的登陆controller，不过用了springsecurity之后就不用这两个啦，而且这两个
    //的return后面只能找到templates目录下面的页面，这点和security不一样，后者只能找到static目录下的页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "mylogin";
    }

    @RequestMapping("/myLogin")
    public String login(String username,String password){
        if(mapper.getInfo(username,password)!=null) return "compute";
        return "mylogin";
    }
}
