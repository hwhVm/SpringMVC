package com.beini.service.impl;

import com.beini.bean.User;
import com.beini.service.UserService;
import com.beini.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Created by beini on 2017/2/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        User user = userMapper.getUser(userId);
        return user;
    }

    @Override
    public List<User> getSelectUser() {
        return userMapper.getSelectUser();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }


}
