package com.beini.test.javase.actual;

import java.io.File;
import java.util.*;

/**
 * Created by beini on 2017/5/9.
 */
public class   RemoveSymbol {
    static String path = "C:\\Users\\Administrator\\Desktop\\dibot 2.0 切片\\dibot 2.0 切片\\png";//文件地址

    public static void main(String[] args) throws Exception {
        File file = new File(path);
        removeSymbol(file);
    }

    public static void removeSymbol(File file) throws Exception {

        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    String name = fileList[i].getName().replace("@", "");
                    fileList[i].renameTo(new File(path + "\\" + name));

                } else {
                    String name = fileList[i].getName().replace("@", "");
                    fileList[i].renameTo(new File(path + "\\" + name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
