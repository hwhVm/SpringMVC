package com.beini.test.javase.strem.io;

import sun.nio.ch.IOUtil;

public class InputStreamTest {


    public static void main(String[] args) {
//          IoUtil.readTextContent("C:\\Users\\Administrator\\Desktop\\aa.txt");
//        IoUtil.copyFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
//        IoUtil.appendFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
        IoUtil.copyByPrintReader("src/com/beini/test/javase/strem/io/app.iml", "src/com/beini/test/javase/strem/io/app.txt");
        //
//        NioUtil.copyFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
    }


}
