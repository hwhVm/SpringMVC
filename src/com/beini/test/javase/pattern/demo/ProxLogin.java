package com.beini.test.javase.pattern.demo;

/**
 * Created by beini on 2017/12/15.
 */
public class ProxLogin implements LoginCallback {
    private LoginCallback login;

    public ProxLogin(LoginCallback login) {
        this.login = login;
    }

    @Override
    public void returnResult() {
        System.out.println(" ProxLogin  returnResult    ");
        login.returnResult();
    }

}
