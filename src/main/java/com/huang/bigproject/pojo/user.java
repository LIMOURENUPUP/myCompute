package com.huang.bigproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:hhl
 * @DATE:2021/8/23 18:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    public String username;
    public String password;
    public int age;
}
