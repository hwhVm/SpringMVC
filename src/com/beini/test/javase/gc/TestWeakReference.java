package com.beini.test.javase.gc;

import com.beini.test.javase.bean.User;

import java.lang.ref.WeakReference;

/**
 * Created by beini on 2017/4/24.
 */
public class TestWeakReference {

    public static void main(String[] args) {
        User user = new User("beini", 33);
        WeakReference<User> userWeakReference = new WeakReference<>(user);

//
//        int i = 0;
//        while (true) {
//            if (userWeakReference.get() != null) {
//                i++;
//                System.out.println("   userWeakReference ");
//                user = null;
//                System.gc();
//            } else {
//                System.out.println("    userWeakReference  collected");
//                break;
//            }
//        }

//        int i = 0;
//        while (true) {
//            if (user != null) {
//                System.out.println("   user ");
//            } else {
//                System.out.println("    userWeakReference  collected");
//                break;
//            }
//        }

//        System.out.println("     i==" + i);

        System.out.println("  returnString()=" + test());
    }

    private static String test() {
        String a = new String("a");
        WeakReference<String> b = new WeakReference<String>(a);
        a = null;
        System.gc();

        String c = "";
        try {
            c = b.get().replace("a", "b");
            return c;
        } catch (Exception e) {
            c = "c";
            return c;
        } finally {
            c += "d";
            return c + "e";
        }
    }

    public static String returnString() {

        try {
            System.out.println(" try   ");
            return "aa";
        } catch (Exception e) {
            System.out.println(" Exception   ");
            return "bb";
        } finally {
            System.out.println(" finally   ");
            return "finally";
        }

    }
}
