package com.wml.controller;


import com.wml.pojo.User;
import com.wml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
        @RequestMapping(value = "/findAll" ,produces = "application/json;charset=utf-8")
        public ModelAndView findAll(){
            //新建时加页面
            ModelAndView mv=new ModelAndView("/index.jsp");
            List<User> list=userService.findAll();
            //在mv中存list带到页面去
            mv.addObject("list",list);
            return mv;
    }
    @RequestMapping("/findByName")
    public ModelAndView findByName(User user){
            ModelAndView mv=new ModelAndView("main.jsp");
            List<User> users=userService.findByName(user);//得到数据
            mv.addObject("list",users);
            return mv;
    }
    @RequestMapping("/delById")
    public ModelAndView delById(@RequestParam("id") String id){
       int count= userService.delById(Integer.parseInt(id));
       if(count>0) {
           return new ModelAndView("/findByName");
       } else {
           return new ModelAndView("/main.jsp");
       }
    }
    @RequestMapping("/insertUser")
    public ModelAndView insertUser(User user){
            int count=userService.insertUser(user);
            if(count>0) {
                return  new ModelAndView("/findByName");
            } else {
                return new ModelAndView("add.jsp");
            }
    }

}
