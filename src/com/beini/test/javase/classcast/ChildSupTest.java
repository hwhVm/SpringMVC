package com.beini.test.javase.classcast;

/**
 * Created by beini on 2017/10/25.
 */
public class ChildSupTest extends SupTest {
    private String password;
    private String email;

    @Override
    public String toString() {
        return "ChildSupTest{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
