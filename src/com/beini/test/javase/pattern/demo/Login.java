package com.beini.test.javase.pattern.demo;


/**
 * Created by beini on 2017/12/15.
 */
public class Login implements LoginCallback {

    public static void main(String[] args) {
        Login login = new Login();
        login.startLogin();
    }

    public void startLogin() {
        LoginModel loginModel = new LoginModel();
//        loginModel.login(new ProxLogin(this));
//        loginModel.login();
    }

    @Override
    public void returnResult() {
        System.out.println("          returnResult    ");
    }
}
