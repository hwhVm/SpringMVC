package com.beini.test.javase.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by beini on 2017/11/9.
 */
public class FileUtils {

    public static void copyFile(String strPath, String destPath) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream filefOutputStream;
        File file = new File(strPath);
        if (!file.exists()) {
            file.createNewFile();
        }
        fileInputStream = new FileInputStream(strPath);
        filefOutputStream = new FileOutputStream(destPath);
        byte[] bufferByte = new byte[100 * 1024];//缓冲区的大小如何设置 ？
        int len, count = 0;
        try {
            while ((len = fileInputStream.read(bufferByte)) != -1) {
                filefOutputStream = new FileOutputStream(destPath);
                filefOutputStream.write(bufferByte, 0, len);
            }
            filefOutputStream.flush();
            filefOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
