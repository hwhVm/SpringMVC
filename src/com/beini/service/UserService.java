package com.beini.service;


import com.beini.bean.User;
import com.beini.utils.PageTableForm;

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

    PageTableForm queryUserInfo(PageTableForm pageTableForm);//分页

    int getCount();//分页得到的数量
}
