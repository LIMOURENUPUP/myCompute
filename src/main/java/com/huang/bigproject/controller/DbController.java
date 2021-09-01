package com.huang.bigproject.controller;

import com.huang.bigproject.mapper.MyMapper;
import com.huang.bigproject.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;

/**
 * @Author:hhl
 * @DATE:2021/8/23 18:16
 */
@RestController
public class DbController {
    @Autowired
    private MyMapper mapper;
    @RequestMapping("/hello")
    public String hello(){
        return "hello!";
    }
    @RequestMapping("/findAll")
    public List<user> findAll(){
        return mapper.findAll();
    }

    @RequestMapping("/findByUserName/{username}")
    public user findByUsername(@PathVariable("username") String username){
        return mapper.findByUserName(username);
    }

    @RequestMapping("/insert/{password}/{username}/{age}")
    public void insert(@PathVariable("password") String password,
                       @PathVariable("username") String username,
                       @PathVariable("age") int age){
        mapper.insertUser(username,password,age);
    }

    @RequestMapping("/deleteByUserName/{username}")
    public void deleteByUserName(@PathVariable("username") String username){
        mapper.deleteByUserName(username);
    }



}
