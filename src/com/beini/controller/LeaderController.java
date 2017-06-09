package com.beini.controller;

import com.beini.bean.Leader;
import com.beini.controller.exception.CustomException;
import com.beini.http.response.BaseResponseJson;
import com.beini.service.LeaderService;
import com.beini.utils.BLog;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
@Component
@Controller
@RequestMapping("/")
public class LeaderController {

    @Autowired
    private LeaderService leaderService;

    /**
     * 测试shiro框架
     */
    @RequestMapping(value = "dologin", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String msg = "";
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        BLog.d("   name==" + userName + "   " + "   password==" + password);
        //userName 和  password不能为null
        Leader leader = new Leader();
        leader.setPassword(password);
        leader.setName(userName);

        //判断是否已经登录
        Subject us = SecurityUtils.getSubject();
        BLog.d("    ---> " + us.isAuthenticated());
        if (us.isAuthenticated()) { // 参数未改变，无需重新登录，默认为已经登录成功
            msg = "success";
        } else {// 需要重新登陆
            // 组装token，包括客户公司名称、简称、客户编号、用户名称；密码
            UsernamePasswordToken token = new UsernamePasswordToken(leader.getName(), leader.getPassword().toCharArray());
            token.setRememberMe(true);
            // shiro登陆验证
            BLog.d("    ---> shiro登陆验证");
            try {
                SecurityUtils.getSubject().login(token);
                msg = "success";
            } catch (UnknownAccountException ex) {
                msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            } catch (IncorrectCredentialsException ex) {
                msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            } catch (ExcessiveAttemptsException e) {
                msg = "登录失败次数过多";
            } catch (LockedAccountException e) {
                msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            } catch (DisabledAccountException e) {
                msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            } catch (ExpiredCredentialsException e) {
                msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            } catch (UnauthorizedException e) {
                msg = "您没有得到相应的授权！" + e.getMessage();
            } catch (AuthenticationException ex) {
                ex.printStackTrace();
                msg = "内部错误，请重试！";
            }
        }

        BLog.d("  msg==" + msg);
        BaseResponseJson responseJson = new BaseResponseJson();
        if ("success".equals(msg)) {
            responseJson.setReturnCode(0);
        } else {
            responseJson.setReturnCode(1);
        }
        response.setContentType("text/htm;charset=utf-8");
        response.setHeader("pragma", " no-cache");
        response.setHeader("cache-control", "no-cache");
        BLog.d(" new Gson().toJson(responseJson)= " + new Gson().toJson(responseJson));
        out.write(new Gson().toJson(responseJson));
    }

    @RequestMapping("queryAllLeader")
    public void queryAllLeader() {
        BLog.d("  queryAllLeader    ");
        List<Leader> leaders = leaderService.queryAll();
        BLog.d("  leaders.size()===" + leaders.size());


    }

    /**
     * 测试SpringMVC异常处理
     */
    @RequestMapping("testSimpleMappingException")
    public void testSimpleMappingException() throws CustomException {
        throw new CustomException("leader  null");
    }


}
