package com.beini.test.javase.pattern.demo;

/**
 * Created by beini on 2017/12/15.
 */
public class LoginModel {

    public void login(LoginCallback login) {

        login.returnResult();

        return ;
    }
}
