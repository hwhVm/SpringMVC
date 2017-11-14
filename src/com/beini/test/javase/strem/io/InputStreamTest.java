package com.beini.test.javase.strem.io;

import com.beini.test.javase.strem.CuttingMerge;
import com.beini.utils.BLog;
import com.beini.utils.MD5Util;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class InputStreamTest {


    public static void main(String[] args) throws FileNotFoundException {
//          IoUtil.readTextContent("C:\\Users\\Administrator\\Desktop\\aa.txt");
//        IoUtil.copyFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
//        IoUtil.appendFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
//        IoUtil.copyByPrintReader("src/com/beini/test/javase/strem/io/app.iml", "src/com/beini/test/javase/strem/io/app.txt");
        //
//        NioUtil.copyFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "C:\\Users\\Administrator\\Desktop\\bb.txt");
//        NioUtil.appendFile(str, dest);
//        String string = MD5Util.file2Md5(new File(str));
//        System.out.println(string);
//        IoUtil.cutOutFile(str, dest, 100, 50);
//        NioUtil.cutOutFile(str, dest, 100, 3075);
        //5549
        String str = "src/com/beini/test/javase/strem/demo/aa.zip";
        String str2 = "src/com/beini/test/javase/strem/demo/bb.zip";
        String dest1 = "src/com/beini/test/javase/strem/demo/1.temp";
        String dest2 = "src/com/beini/test/javase/strem/demo/2.temp";

        String dest = "src/com/beini/test/javase/strem/demo/";
//        List<String> stringList = CuttingMerge.cuttingFile(str, dest);
      NioUtil.cutOutFile(str, dest1, 0, 5000);
      NioUtil.cutOutFile(str, dest2, 5000, 549);
        List<String> strings = new ArrayList<>();
        strings.add(dest1);
        strings.add(dest2);
        CuttingMerge.merge(strings, str2);

    }


}
