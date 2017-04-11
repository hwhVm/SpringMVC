package com.beini.controller;


import com.beini.bean.User;
import com.beini.constants.Constant;
import com.beini.service.UserService;
import com.beini.utils.BLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by beini on 2017/2/22.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 同步操作
     *
     * @param user
     * @return
     */
    @RequestMapping(Constant.ADD_USER)
    public String addUser(User user) {

        userService.insertUser(user);

        return Constant.SUCCESS;
    }

    @RequestMapping(Constant.QUERY_ALL)
    public String queryAll(ModelMap modelMap) {
        List<User> userList = userService.getSelectUser();
        modelMap.addAttribute(Constant.USER_LIST, userList);
        return Constant.SHOW_LIST;
    }

    @RequestMapping(Constant.DETELE_ITEM)
    public String DeteleItem(@RequestParam(Constant.ID) Integer id) {
        int result = userService.deleteUser(id);
        if (result == 1) {
            return Constant.SUCCESS;
        } else {
            return Constant.FAILED;
        }
    }


    /**
     * 异步操作
     *
     * @return
     */

    @RequestMapping(value = "longtimetask", method = RequestMethod.GET)
    public WebAsyncTask longTimeTask() {
        BLog.d("/longtimetask被调用 thread id is : " + Thread.currentThread().getId());
        Callable<ModelAndView> callable = new Callable<ModelAndView>() {
            public ModelAndView call() throws Exception {
                Thread.sleep(3000); //假设是一些长时间任务
                ModelAndView mav = new ModelAndView("success");
                mav.addObject("result", "执行成功");
                BLog.d("执行成功 thread id is : " + Thread.currentThread().getId());
                return mav;
            }
        };
        return new WebAsyncTask(callable);
    }

    @RequestMapping("/response-body")
    public
    @ResponseBody
    Callable<String> callable() {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Callable result";
            }
        };
    }

    @RequestMapping("/view")
    public Callable<String> callableWithView(final Model model) {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                model.addAttribute("foo", "bar");
                model.addAttribute("fruit", "apple");
                return "views/html";
            }
        };
    }

    @RequestMapping("/exception")
    public
    @ResponseBody
    Callable<String> callableWithException(
            final @RequestParam(required = false, defaultValue = "true") boolean handled) {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                if (handled) {
                    // see handleException method further below
                    throw new IllegalStateException("Callable error");
                } else {
                    throw new IllegalArgumentException("Callable error");
                }
            }
        };
    }

    @RequestMapping("/custom-timeout-handling")
    public
    @ResponseBody
    WebAsyncTask<String> callableWithCustomTimeoutHandling() {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Callable result";
            }
        };

        return new WebAsyncTask<String>(1000, callable);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView(Constant.FAILED);
        model.addObject("result", ex.getMessage());

        return model;
    }

    @RequestMapping("/quotes")
    @ResponseBody
    public DeferredResult<String> quotes() {
        DeferredResult<String> deferredResult = new DeferredResult<String>();
        // Add deferredResult to a Queue or a Map...
//        deferredResult.setResult("  ")
        return deferredResult;
    }


}
