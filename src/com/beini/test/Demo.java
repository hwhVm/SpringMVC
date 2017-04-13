package com.beini.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by beini on 2017/4/13.
 */
public class Demo {
    private static final String HEX_NUMS_STR = "0123456789ABCDEF";
//    A8445619ABD08F3BA0EBFCB31183F7F9

    public static void main(String[] args) {
//        try {
//            String str1 = "123";
//            String str2="123";
//
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(Test.hexStringToByte(str1))   ;
////            md.update(Test.hexStringToByte(str2));
//            System.out.println("  str=="+str1);
//            System.out.println("   "+Test.byteToHexString(md.digest()));
//
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        getPassword();
    }

    private static List<String> getPassword() {
        List<String> strings = new ArrayList<>();
        int total = 0;
        co:
        for (int a = 0; a <= 8; a++) {
            for (int b = 0; b <= 8; b++) {
                for (int c = 0; c <= 8; c++) {
                    for (int d = 0; d <= 8; d++) {
                        for (int e = 0; e <= 8; e++) {
                            for (int f = 0; f <= 8; f++) {
                                for (int g = 0; g <= 8; g++) {
                                    for (int h = 0; h <= 8; h++) {
                                        strings.add(a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g + "" + h);
                                        System.out.println(a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g + "" + h);
                                        total++;
                                        if ((a + "" + b + "" + c + "" + d + "" + e + "" + f + "" + g + "" + h).equals("00002308")) {
                                            break co;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("  total== " + total);
        return strings;
    }
}
