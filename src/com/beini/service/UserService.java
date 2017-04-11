package com.beini.service;


import com.beini.bean.User;

import java.util.List;

/**
 * Created by beini on 2017/2/23.
 */
public interface UserService {
    User getUserById(int userId);


    List<User> getSelectUser();


    void updateUser(User user);


    void insertUser(User user);


    int deleteUser(int id);


}
