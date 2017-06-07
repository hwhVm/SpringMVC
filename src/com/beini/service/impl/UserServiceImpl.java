package com.beini.service.impl;

import com.beini.bean.User;
import com.beini.service.UserService;
import com.beini.mapper.UserMapper;
import com.beini.utils.PageTableForm;
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

    private List<User> userList;

    @Override
    public PageTableForm queryUserInfo(PageTableForm pageTableForm) {
        System.out.println("pageTableForm.getCurrentPage()= " + pageTableForm.getCurrentPage() + "  pageTableForm.getPageSize()= " + pageTableForm.getPageSize());
        userList = userMapper.queryUserInfo(pageTableForm.getCurrentPage(), pageTableForm.getPageSize());

        pageTableForm.setUserList(userList);
        System.out.println("     userList.size()=" + userList.size());
        return pageTableForm;
    }

    @Override
    public int getCount() {
        return userMapper.getCount();
    }

    @Override
    public List<User> queryUserByPassord(User user) {
        return userMapper.queryUserByPassord(user.getName(), user.getPassword());
    }


}
