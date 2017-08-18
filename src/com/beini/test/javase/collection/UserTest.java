package com.beini.test.javase.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by beini on 2017/4/21.
 */
public class UserTest {
    static {
        System.out.println("----------------->UserTest");
    }

    public static void main(String[] args) throws InterruptedException {
//        int  ii=981;
//        System.out.println("   ii=="+(byte)ii);
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
//        System.out.println("dd".equals(String.class));
//        /**
//         * 代码 》 编译 》 字节码
//         */
//        A a1 = new A();
//        System.out.println(" a1="+a1.a);
//        System.out.println(" a1.returnA()="+a1.returnA());
//        B b1 = new B();
//        System.out.println(" b1="+b1.a);
//        System.out.println(" b1.returnA()="+b1.returnA());
//        A a2 = new B();
//        System.out.println(" a2="+a2.a);
//        System.out.println(" a2.returnA()="+a2.returnA());

//        List<Integer> list = new ArrayList<Integer>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
////正常循环
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("i的值:" + i + " 对应的数字:" + list.get(i));
//        }
//        System.out.println("没有remove前list的项:"+list.size());
//
////边循环边删除
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i) == 3) {
//                list.remove(list.get(i));//删除list的第四项
//                list.add(i, 99);
//            }
//        }
//        System.out.println("   ------------------------------------>");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("i的值:" + i + " 对应的数字:" + list.get(i));
//        }
//        System.out.println("没有remove前list的项:"+list.size());
//    }
//        List<Integer> lists1 = new ArrayList<>();
//        lists1.add(1);
//        lists1.add(2);
//        lists1.add(3);
//        List<Integer> lists2 = new ArrayList<>();
//        lists2.add(4);
//        lists2.add(5);
//        lists2.add(6);
//
//        lists1.clear();
//        System.out.println("   "+lists1.size());
//        lists1.addAll(lists2);
//
//        for (int i = 0; i < lists1.size(); i++) {
//            System.out.println("   lists1=" + lists1.get(i));
//        }
//        List<String> strings = new ArrayList<>();
//        strings.add("dd");
//        strings.clear();
//        System.out.println("        ---------->" + strings.size());
//        for (int i = 0; i < strings.size(); i++) {
//            strings.get(0);
//        }
    }
}
