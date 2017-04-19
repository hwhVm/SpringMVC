package com.beini.controller.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by beini on 2017/4/19.
 */
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        CustomException customException;
        if (e instanceof CustomException) {
            customException = (CustomException) e;
        } else {
            customException = new CustomException("系统未知错误");
        }
        //向前台返回错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", customException.getMessage());
        modelAndView.setViewName("/error/error");
        return modelAndView;
    }
}
