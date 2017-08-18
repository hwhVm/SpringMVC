package com.beini.test.javase.static_factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by beini on 2017/8/14.
 */
public class StaticTest {

    public static void main(String[] agrs) {
//        BuilderModel builderModel = new BuilderModel.Builder("dd", 33)
//                .set("")
//                .builder();

//        BuilderModel builderModel = BuilderModel.builder("", 11).setPassword("");

        //
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 55000000; i++) {
            integers.add(i);
        }

        try {
            long j_start = System.currentTimeMillis();
            for (Integer ss : integers) {

            }
            long j_end = System.currentTimeMillis();
            System.out.println(" j_end-j_start=" + (j_end - j_start));
        } catch (Exception e) {

        }


        //
//        long i_start = System.currentTimeMillis();
//        for (Integer ss : integers) {
//
//        }
//        long i_end = System.currentTimeMillis();
//        System.out.println(" i_end-i_start=" + (i_end - i_start));
        //


    }

}
