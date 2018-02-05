package com.beini.test.javase.pattern.builderPattern;


/**
 * Created by beini on 2018/2/5.
 * 建造者模式:把类的表现和构建分离开来
 */
public class Test {

    public static void main(String args[]) {
        User.Builder builder = new User.Builder();
        builder.setUserName("beini");
        builder.setUserPassword("123456");
        User user = builder.builder();
        System.out.println(" " + user.getUserName() + "  " + user.getUserPassword());

        User.Builder user1 = new User.Builder();
        user1.builder();
    }

}
