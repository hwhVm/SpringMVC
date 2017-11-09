package com.beini.test.javase.io.okioPackage;

import com.beini.test.javase.io.FileUtils;
import okio.*;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by beini on 2017/11/9.
 */
public class OkioTest {

    private static Object RealBufferedSink;

    /**
     * 除了读写还有一些压缩工具类，Okio是对java底层io的封装
     * <p>
     * 采用了segment的机制进行内存共享和复用，避免了copy数组；
     * 根据需要动态分配内存大小；
     * 避免了数组创建时的zero-fill，同时降低GC的频率。
     * <p>
     * 使用了装饰者模式便于扩展
     *
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
//        long start1 = System.currentTimeMillis();
//        copyFile();
//        long end1 = System.currentTimeMillis();
//        System.out.println("   " + (end1 - start1));
//        try {
//            long start2 = System.currentTimeMillis();
//            FileUtils.copyFile("C:\\Users\\Administrator\\Desktop\\aa.zip", "C:\\Users\\Administrator\\Desktop\\bb.zip");
//            long end2 = System.currentTimeMillis();
//            System.out.println("   " + (end2 - start2));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


    /**
     * ForwardingSink
     * ForwardingSource
     */
    static SinkListen sinkListen = (bytesWritten, contentLength) -> {
        System.out.println("-------> bytesWritten= " + bytesWritten + "   contentLength=" + contentLength);
    };

    public static void copyFile() {
        File fileRead = new File("C:\\Users\\Administrator\\Desktop\\aa.zip");
        File fileWrite = new File("C:\\Users\\Administrator\\Desktop\\bb.zip");
        BufferedSink bufferedSink;

        try {
            Source source = Okio.source(fileRead);
            Sink sink = Okio.sink(fileWrite);
            CusForwardingSink cusForwardingSink = new CusForwardingSink(sink, fileRead, sinkListen);
            bufferedSink = Okio.buffer(cusForwardingSink);
            //
//          bufferedSink = Okio.buffer(Okio.sink(fileWrite));
            bufferedSink.writeAll(source);
            bufferedSink.flush();

            source.close();
            sink.close();
            bufferedSink.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWrite() {
        File fileRead = new File("C:\\Users\\Administrator\\Desktop\\demo.txt");
        BufferedSource bufferedSource = null;
        try {
            bufferedSource = Okio.buffer(Okio.source(fileRead));
            System.out.println(bufferedSource.readString(Charset.forName("GBK")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        File fileWrite = new File("C:\\Users\\Administrator\\Desktop\\aa.txt");
        BufferedSink bufferedSink = null;
        try {
            bufferedSink = Okio.buffer(Okio.sink(fileWrite));
            bufferedSink.writeString("1234设置", Charset.forName("GBK"));
            bufferedSink.flush();//注意刷新缓冲区

            bufferedSink.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
