package com.huang.bigproject.service;

import com.huang.bigproject.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:hhl
 * @DATE:2021/8/23 20:33
 */
public class serviceImp implements service{
    @Autowired
    MyMapper mapper;

}
