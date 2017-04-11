package com.beini.controller.mobile;

import com.beini.bean.User;
import com.beini.constants.Constant;
import com.beini.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public void queryAll(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter ) {
        printWriter.write("queryAll ");
    }

}
