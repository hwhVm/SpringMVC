package com.beini.controller.exception;

/**
 * Created by beini on 2017/4/19.
 */
public class CustomException extends Exception {
    //异常信息
    public String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
