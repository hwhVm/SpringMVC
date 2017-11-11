package com.beini.test.javase.strem;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * Created by beini on 2017/10/28.
 * 1 RandomAccessFile
 * 2 解决编码问题 OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
 *它的实现是java.util.zip.DeflaterOutputStream / InflaterInputStream。
 */
public class CuttingMerge {

    private static double bufferSize;

    public static void main(String[] args) throws IOException {
        String filePath = "D:/demo/aa.zip";
        String cellFilePath = "D:/demo/temp/";
        bufferSize = 10 * 1024;
        bufferSize = getSize(new File(filePath)) / 10;

        List<String> cellsPath = cuttingFile(filePath, cellFilePath);
        System.out.println("  cellsPath.size() =" + cellsPath.size());

        //

        //
        String newFilePath = "D:/demo/copy/2.zip";
        merge(cellsPath, newFilePath);
        deteleTempFile(cellsPath);
    }

    public static void deteleTempFile(List<String> cellsPath) {
        for (int i = 0; i < cellsPath.size(); i++) {
            File file = new File(cellsPath.get(i));
            System.out.println("   " + cellsPath.get(i));
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void merge(List<String> cellsPath, String newFilePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFilePath);
            ArrayList<FileInputStream> cellsInputString = new ArrayList<>();

            for (int i = 0; i < cellsPath.size(); i++) {
                cellsInputString.add(new FileInputStream(cellsPath.get(i)));
            }
            Iterator<FileInputStream> iterator = cellsInputString.iterator();
            Enumeration<FileInputStream> enumeration = new Enumeration<FileInputStream>() {
                @Override
                public boolean hasMoreElements() {
                    return iterator.hasNext();
                }

                @Override
                public FileInputStream nextElement() {
                    return iterator.next();
                }
            };

            SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
            int count;

            byte[] buf = new byte[(int) bufferSize];
            while ((count = sequenceInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, count);
            }
            sequenceInputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static List<String> cuttingFile(String filePath, String cellFilePath) {
        FileInputStream fileInputStream;
        FileOutputStream filefOutputStream;
        List<String> cellsPath = new ArrayList<>();

        byte[] bufferByte = new byte[(int) bufferSize];//缓冲区的大小如何设置 ？
        int len, count = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            while ((len = fileInputStream.read(bufferByte)) != -1) {
                String outPath = cellFilePath + count++ + ".temp";
                filefOutputStream = new FileOutputStream(outPath);
                cellsPath.add(outPath);
                filefOutputStream.write(bufferByte, 0, len);
                filefOutputStream.flush();
                filefOutputStream.close();
            }
            fileInputStream.close();
            return cellsPath;
        } catch (IOException e) {
            e.printStackTrace();
            return cellsPath;
        }

    }

    /**
     * 计算文件或者文件夹的大小 ，单位 字节
     */
    public static double getSize(File file) {
        if (!file.isFile()) {
            File[] files = file.listFiles();
            double size = 0;
            for (File f : files)
                size += getSize(f);
            return size;
        } else {
            double size = (double) file.length();
            return size;
        }
    }
}
