package com.beini.test.javase.pattern.builderPattern;

/**
 * Created by beini on 2018/2/5.
 */
public class User {
    private final String userName;
    private final String userPassword;

    public User(Builder builder) {
        this.userName = builder.userName;
        this.userPassword = builder.userPassword;
    }

    public static class Builder {
        private String userName;
        private String userPassword;

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setUserPassword(String userPassword) {
            this.userPassword = userPassword;
            //加密
            return this;
        }

        public User builder() {
            return new User(this);
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
