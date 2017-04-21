package com.beini.test.javase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by beini on 2017/4/21.
 */
public class UserTest {

    public static void main(String[] args) throws InterruptedException {
        List<User> users = new ArrayList<>();
        users.add(new User("beini1", 11));
        users.add(new User("beini2", 12));
        users.add(new User("beini4", 14));
        users.add(new User("beini3", 13));
        Collections.sort(users);
        users.stream().filter(Objects::nonNull).forEach(user2 -> System.out.println("    " + user2.getAge()));

        User user = new User("beini3", 13);

        //检索student在list中的位置
        int index1 = users.indexOf(user);
        int index2 = Collections.binarySearch(users, user);

        System.out.println("index1 = " + index1);
        System.out.println("index2 = " + index2);

    }
}
