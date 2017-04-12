package com.beini.controller.mobile;

import com.beini.bean.User;
import com.beini.constants.Constant;
import com.beini.http.request.PageRequest;
import com.beini.http.request.UserRequest;
import com.beini.http.response.BaseResponseJson;
import com.beini.service.UserService;
import com.beini.utils.PageTableForm;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by beini on 2017/4/11.
 */
@Controller
public class UserMController {
    @Autowired
    private UserService userService;

    @RequestMapping("queryAllM")
    public void queryAllM(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
        printWriter.write("queryAll ");
    }

    @RequestMapping("insertUserM")
    public void addUserM(@RequestBody UserRequest userRequest,
                         HttpServletResponse response, PrintWriter out) {

        String userName = userRequest.getName();
        int age = userRequest.getAge();
        System.out.println("userName is:" + userName + "   age is:" + age);

        User user = new User();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        userService.insertUser(user);

        BaseResponseJson responseJson = new BaseResponseJson();


        response.setContentType("text/htm;charset=utf-8");
        response.setHeader("pragma", " no-cache");
        response.setHeader("cache-control", "no-cache");
        out.write(new Gson().toJson(responseJson).toString());

    }

    @RequestMapping("getUserByPage")
    public void getUserByPage(@RequestBody PageRequest pageRequest,
                              HttpServletResponse response, PrintWriter out) {
        PageTableForm pageTableForm = new PageTableForm();
        System.out.println(" == "+pageRequest.getStart()+"    =="+pageRequest.getNum());
        pageTableForm.setCurrentPage(pageRequest.getStart());
        pageTableForm.setPageSize(pageRequest.getNum());

        PageTableForm pageTableForm1 = userService.queryUserInfo(pageTableForm);
        List<User> userList = pageTableForm1.getUserList();

        for (User user1 : userList) {
            System.out.println("    " + user1.getName());
        }

    }
}
