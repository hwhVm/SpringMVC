package com.beini.http.request;

/**
 * Created by beini on 16-10-14.
 */

public class BaseRequestJson {


    /**
     * UserId : 300000001
     * Token : 1476427063
     * UserToken :  ViF/5gGslTJH3wvyxZ2cMjKFj3OBNVw7EJ20/GVlWkeQHlROWittETcWuF2W9Ipdvrcp49B5sY6ccs0XNKDNKyJoT/dJfcV8
     */

    static private int UserId; //用户ID
    static private int Token; //服务器Token

    public int getUserId() {
        return UserId;
    }

    static public void setUserId(int Id) {
        UserId = Id;
    }

    public int getToken() {
        return Token;
    }

    static public void setToken(int to) {
        Token = to;
    }
}
