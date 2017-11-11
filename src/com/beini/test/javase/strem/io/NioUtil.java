package com.beini.test.javase.strem.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by beini on 2017/11/11.
 */
public class NioUtil {
    /**
     * 使用Buffer读写数据一般遵循以下四个步骤：
     * <p>
     * 1 写入数据到Buffer
     * 2 调用flip()方法
     * 3 从Buffer中读取数据
     * 4 调用clear()方法或者compact()方法
     *
     * @param filePath
     */

    public static void readTextContent(String filePath) {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(filePath, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) randomAccessFile.length());//2g

            int byteRead = fileChannel.read(byteBuffer);

            while (byteRead != -1) {
                byteBuffer.flip();//将Buffer从写模式切换到读模式
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                //清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
                byteBuffer.compact();
                byteRead = fileChannel.read(byteBuffer);
            }
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String strPath, String destPath) {
        RandomAccessFile randomAccessStr;
        RandomAccessFile randomAccessDest;
        try {
            randomAccessStr = new RandomAccessFile(strPath, "rw");
            randomAccessDest = new RandomAccessFile(destPath, "rw");

            FileChannel fileChannelStr = randomAccessStr.getChannel();
            FileChannel fileChannel1Dest = randomAccessDest.getChannel();

            fileChannel1Dest.transferFrom(fileChannelStr, 0, fileChannelStr.size());

            randomAccessStr.close();
            randomAccessDest.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void writeBytesToStorage(String fileDir, byte[] data) {
        try {
            RandomAccessFile fos = new RandomAccessFile(fileDir, "rw");
            FileChannel fileChannel = fos.getChannel();
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, data.length);
            buffer.put(data);
            fileChannel.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
