package com.beini.test.javase.strem.io;

import com.beini.utils.BLog;
import com.beini.utils.MD5Util;
import sun.nio.ch.IOUtil;
import java.io.*;
import java.nio.channels.FileChannel;
public class InputStreamTest {


    public static void main(String[] args) throws FileNotFoundException {
//          IoUtil.readTextContent("C:\\Users\\Administrator\\Desktop\\aa.txt");
//        IoUtil.copyFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
//        IoUtil.appendFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
//        IoUtil.copyByPrintReader("src/com/beini/test/javase/strem/io/app.iml", "src/com/beini/test/javase/strem/io/app.txt");
        //
//        NioUtil.copyFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
        String str = "src/com/beini/test/javase/strem/io/aa";
        String dest = "src/com/beini/test/javase/strem/io/bb";
//        NioUtil.appendFile(str, dest);
//        String string = MD5Util.file2Md5(new File(str));
//        System.out.println(string);
        NioUtil.cutOutFile(str,dest);
    }


}
