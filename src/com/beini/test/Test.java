package com.beini.test;


import com.beini.bean.User;
import com.beini.service.UserService;
import com.beini.service.impl.UserServiceImpl;
import com.beini.utils.BLog;
import com.beini.utils.PageTableForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by beini on 2017/2/23.
 */
@Controller
public class Test {
    @Autowired
     static UserService userService=new UserServiceImpl();

    public static void main(String[] args) {
        User user = new User();
        user.setName("ddd");
        user.setAge(22);
        System.out.println(" (userService==null)= " + (userService == null));
        userService.insertUser(user);
        userService.insertUser(user);
        userService.insertUser(user);


    }
}
