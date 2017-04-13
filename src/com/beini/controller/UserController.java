package com.beini.controller;


import com.beini.bean.User;
import com.beini.constants.Constant;
import com.beini.service.UserService;
import com.beini.utils.BLog;
import com.beini.utils.PageTableForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Map;
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
     */
    //对于ModelAndView构造函数可以指定返回页面的名称，也可以通过setViewName方法来设置所需要跳转的页面；
    @RequestMapping(value="/index1",method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/user/index");
//        modelAndView.setViewName("/user/index");
        modelAndView.addObject("name", "xxx");
        return modelAndView;
    }

    /**
     * 分页
     */
    @RequestMapping("list")
    public String queryUserInfo(Model model, PageTableForm pageTableForm) {
        pageTableForm = userService.queryUserInfo(pageTableForm);
        model.addAttribute("pageTableForm", pageTableForm);
        return "user_list";
    }

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
     * 使用重定向的方式，改变浏览器的地址栏，防止表单因为刷新重复提交。
     *
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(@RequestParam Map<String, String> user, RedirectAttributes model) {
        System.out.println("用户提交了一次表单");
        String username;
        if (user.get("name").isEmpty()) {
            username = "Tom";
        } else {
            username = user.get("name");
        }
        model.addFlashAttribute("msg", username);
//      return "home";//此方式跳转，页面刷新会重复提交表单
        return "redirect:toHome";
    }

    @RequestMapping("toHome")
    public String home(@ModelAttribute("msg") String msg, Model model) {
        System.out.println("拿到重定向得到的参数msg:" + msg);
        model.addAttribute("msg", msg);
        return "home";
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
