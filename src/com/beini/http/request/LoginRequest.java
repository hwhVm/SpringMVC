package com.beini.http.request;

/**
 * Created by beini on 2017/6/7.
 */
public class LoginRequest {
    private String account;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


}
