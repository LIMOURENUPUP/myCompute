package com.huang.bigproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:hhl
 * @DATE:2021/8/24 14:34
 */
@Controller
public class computeCtrl {
     @RequestMapping("/toAdd")
     public String toAdd(){
         return "compute";
     }

    @RequestMapping("/add")
    public String add(Integer a, Integer b, Model model){
         if(a!=null&&b!=null)
            model.addAttribute("res",a+b);
         return "compute";
    }


}
