package com.beini.test.javase.classcast;

import com.google.gson.Gson;

/**
 * Created by beini on 2017/10/25.
 */
public class CastTest {

    public static void main(String[] args) {
        ChildSupTest childSupTest = getChildSupTest();

        String string = new Gson().toJson(childSupTest);
        System.out.println(" string=" + string);

        SupTest supTest = new Gson().fromJson(string, SupTest.class);
        System.out.println("  supTest =" + supTest.toString());

        ChildSupTest childSupTest1 = (ChildSupTest) supTest;
        System.out.println(" childSupTest1="+childSupTest1.toString());

//        Object object = childSupTest;
//
//        SupTest supTest = childSupTest;
//
//        System.out.println("   " + supTest.getName() + "   " + supTest.getId());
//
//        ChildSupTest gg = (ChildSupTest) supTest;
//        System.out.println("   " + gg.getName() + "   " + gg.getId());
//        System.out.println("   " + gg.getEmail());
//
//        ChildSupTest hh = (ChildSupTest) object;
//        System.out.println("       -----------------   ");
//        System.out.println("   " + hh.getName() + "   " + hh.getId());
//        System.out.println("   " + hh.getEmail());
    }


    public static ChildSupTest getChildSupTest() {
        ChildSupTest childSupTest = new ChildSupTest();
        childSupTest.setEmail("email");
        childSupTest.setPassword("password");
        childSupTest.setId(0);
        childSupTest.setName("beini");

        return childSupTest;
    }
}
