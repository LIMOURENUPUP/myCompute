package com.huang.bigproject.mapper;


import com.huang.bigproject.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyMapper {
     user findByUserName(String username);
     List<user> findAll();
     void insertUser(String username,String password,int age);
     void deleteByUserName(String username);
     user getInfo(String username,String password);
}
