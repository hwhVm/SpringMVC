package com.beini.test.javase.string;

import com.beini.utils.BLog;

/**
 * Created by beini on 2017/12/5.
 */
public class Test {

    public static void main(String[] agrs) {
        String string = "aaaa.jpg";
        int i = string.indexOf(".");
        BLog.d("      i=" + i);
        String demo = string.substring(4, string.length());
        BLog.d("      demo=" + demo);
    }


}
