package com.zdk.service;

import com.zdk.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryUsers();
    public Integer updateUser(User user);
    public Integer saveUser(User user);
    public Integer deleteUser(Integer id);
}
