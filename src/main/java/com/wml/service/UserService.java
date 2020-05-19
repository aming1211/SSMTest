package com.wml.service;


import com.wml.mapper.UserMapper;
import com.wml.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> findAll(){
        return userMapper.findAll();
    }
    public List<User> findByName(User user){
        return userMapper.findByName(user);
    }
    public int delById(int  id){
        return  userMapper.delByid(id);
    }
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }
}
