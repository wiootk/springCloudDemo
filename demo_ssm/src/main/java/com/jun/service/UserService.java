package com.jun.service;

import com.jun.entity.User;
import com.jun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public List<User> likeName(String name){
        return mapper.findByNameLike(name);
    }


    public long save(User user){
        return mapper.insert(user);
    }

    public User getById(long id){
        return mapper.getById(id);
    }
}