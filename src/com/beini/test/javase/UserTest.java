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
//        List<User> users = new ArrayList<>();
//        users.add(new User("beini1", 11));
//        users.add(new User("beini2", 12));
//        users.add(new User("beini4", 14));
//        users.add(new User("beini3", 13));
//        Collections.sort(users);
//        users.stream().filter(Objects::nonNull).forEach(user2 -> System.out.println("    " + user2.getAge()));
//
//        User user = new User("beini3", 13);
//
//        //检索student在list中的位置
//        int index1 = users.indexOf(user);
//        int index2 = Collections.binarySearch(users, user);
//
//        System.out.println("index1 = " + index1);
//        System.out.println("index2 = " + index2);
        System.out.println("dd".equals(String.class));
        /**
         * 代码 》 编译 》 字节码
         */
        A a1 = new A();
        System.out.println(" a1="+a1.a);
        System.out.println(" a1.returnA()="+a1.returnA());
        B b1 = new B();
        System.out.println(" b1="+b1.a);
        System.out.println(" b1.returnA()="+b1.returnA());
        A a2 = new B();
        System.out.println(" a2="+a2.a);
        System.out.println(" a2.returnA()="+a2.returnA());
    }
}
