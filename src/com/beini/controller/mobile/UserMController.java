package com.beini.controller.mobile;

import com.beini.bean.User;
import com.beini.controller.BaseController;
import com.beini.http.request.LoginRequest;
import com.beini.http.request.PageRequest;
import com.beini.http.request.UserRequest;
import com.beini.http.response.BaseResponseJson;
import com.beini.service.UserService;
import com.beini.utils.BLog;
import com.beini.utils.Base64Util;
import com.beini.utils.PageTableForm;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by beini on 2017/4/11.
 */
@Controller
public class UserMController extends BaseController {

    /**
     * login
     *
     * @param loginRequest
     * @param response
     * @param out
     */
    @RequestMapping("loginm")
    public void loginM(@RequestBody LoginRequest loginRequest,
                       HttpServletResponse response, PrintWriter out) {
        String account = loginRequest.getAccount();
        String password = loginRequest.getPassword();
        BLog.d("  account=" + account + "   password=" + password);
        User user = new User();
        user.setName(account);
        user.setPassword(password);
        List<User> users = userService.queryUserByPassord(user);

        BaseResponseJson responseJson = new BaseResponseJson();
        if (users != null && users.size() == 1) {
            responseJson.setReturnCode(0);
        } else {
            responseJson.setReturnCode(1);
        }

        response.setContentType("text/htm;charset=utf-8");
        response.setHeader("pragma", " no-cache");
        response.setHeader("cache-control", "no-cache");
        out.write(new Gson().toJson(responseJson));
    }

    /**
     * query all
     *
     * @param request
     * @param response
     * @param printWriter
     */
    @RequestMapping("queryAllM")
    public void queryAllM(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
        printWriter.write("queryAll ");
    }

    /**
     * 添加 User
     *
     * @param userRequest
     * @param response
     * @param out
     */
    @RequestMapping("insertUserM")
    public void addUserM(@RequestBody UserRequest userRequest,
                         HttpServletResponse response, PrintWriter out) {

        String userName = userRequest.getName();
        int age = userRequest.getAge();
        System.out.println("userName is:" + userName + "   age is:" + age);

        User user = new User();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        //满足条件进行插入
        userService.insertUser(user);

        BaseResponseJson responseJson = new BaseResponseJson();
        responseJson.setReturnCode(0);

        response.setContentType("text/htm;charset=utf-8");
        response.setHeader("pragma", " no-cache");
        response.setHeader("cache-control", "no-cache");
        out.write(Base64Util.encode(new Gson().toJson(responseJson)));

    }

    @RequestMapping("getUserByPage")
    public void getUserByPage(@RequestBody PageRequest pageRequest,
                              HttpServletResponse response, PrintWriter out) {
        PageTableForm pageTableForm = new PageTableForm();
        System.out.println(" == " + pageRequest.getStart() + "    ==" + pageRequest.getNum());
        pageTableForm.setCurrentPage(pageRequest.getStart());
        pageTableForm.setPageSize(pageRequest.getNum());

        PageTableForm pageTableForm1 = userService.queryUserInfo(pageTableForm);
        List<User> userList = pageTableForm1.getUserList();

        for (User user1 : userList) {
            System.out.println("    " + user1.getName());
        }

    }

    /**
     * 请求也可以使用通配符
     *
     * @return
     */
    @RequestMapping(value = "test_request_body", method = RequestMethod.GET)
    public @ResponseBody
    String testRequestBody() {
        System.out.println("    testRequestBody ");
        return " 返回 response body";
    }

}
