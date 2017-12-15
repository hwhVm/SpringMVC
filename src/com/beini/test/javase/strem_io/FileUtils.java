package com.beini.test.javase.strem_io;

import java.io.File;

/**
 * Created by beini on 2017/11/9.
 */
public class FileUtils {

    /**
     * 计算文件或者文件夹的大小 ，单位 MB
     */
    public double getSize(File file) {
        if (!file.isFile()) {
            File[] files = file.listFiles();
            double size = 0;
            for (File f : files)
                size += getSize(f);
            return size;
        } else {
            double size = (double) file.length() / 1024 / 1024;
            return size;
        }
    }
}
