package com.zdk.service;

import com.zdk.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public List<User> queryUsers() {
        System.out.println("query users");
        return new ArrayList<>();
    }

    @Override
    public Integer updateUser(User user) {
        System.out.println("update user");
//        if(true){
//           throw new NullPointerException("test throws");
//        }
        return 1;
    }

    @Override
    public Integer saveUser(User user) {
        System.out.println("save user");
        return 1;
    }

    @Override
    public Integer deleteUser(Integer id) {
        System.out.println("delete user");
        return 1;
    }
}
