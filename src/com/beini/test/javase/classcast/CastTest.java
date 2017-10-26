package com.beini.test.javase.classcast;


import java.io.*;

/**
 * Created by beini on 2017/10/25.
 */
public class CastTest {

    public static void main(String[] args) throws IOException {
//        ChildSupTest childSupTest = getChildSupTest();
//
//        String string = new Gson().toJson(childSupTest);
//        System.out.println(" string=" + string);
//
//        SupTest supTest = new Gson().fromJson(string, SupTest.class);
//        System.out.println("  supTest =" + supTest.toString());
//
//        ChildSupTest childSupTest1 = (ChildSupTest) supTest;
//        System.out.println(" childSupTest1="+childSupTest1.toString());

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

//        InputStream inputStream = null;
//        Writer writer = null;
//        try {
//            inputStream = new FileInputStream(new File("C:/Users/Administrator/Desktop/a.txt"));
//            byte b[] = new byte[100];
//            inputStream.read(b);
//            System.out.println(new String(b));
//
//        }catch (final Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                inputStream.close();
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        }

        String a =new String( "A");
        Integer i = 9;

        CastTest c = new CastTest();
        c.read(a);
        c.read(i);

        System.out.println(i);


    }


    public int read(String b) {
        b = "B";
        return 0;
    }

    public int read(int i) {
        i = 55;
        return 33;
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
