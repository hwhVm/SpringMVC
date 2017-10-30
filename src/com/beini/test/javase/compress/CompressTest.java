package com.beini.test.javase.compress;


import net.jpountz.lz4.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.GZIPOutputStream;

/**
 * Created by beini on 2017/10/28.
 */
public class CompressTest {
    /**
     * 压缩：Google  Snappy ,https://github.com/xerial/snappy-java
     * zlib:
     * lz4:https://github.com/lz4/lz4-java
     * java 自带的：
     * <p>
     * JDK GZIP:压缩比高的慢速算法，压缩后的数据适合长期使用。JDK中的java.util.zip.GZIPInputStream / GZIPOutputStream便是这个算法的实现。
     * <p>
     * , JDK deflate:
     * 这是JDK中的又一个算法（zip文件用的就是这一算法）。它与gzip的不同之处在于，你可以指定算法的压缩级别，这样你可以在压缩时间和输出文件大小上进行平衡。可选的级别有0（不压缩），以及1(快速压缩)到9（慢速压缩）。
     * http://www.findsrc.com/columnist/detail/8638
     */


    //文件压缩
    public static void compressFile() throws IOException {
        String filePath = "D:/demo/aa.doc";
        String cellFilePath = "D:/demo/copy/aa.zip";

//        byte[] compressByte = Lz4Util.lz4Compress(Lz4Util.returnFileByte(filePath), 1024);
        byte[] srcByte = Lz4Util.returnFileByte(filePath);
        byte[] compressByte = Lz4Util.compressedByte(srcByte);
        //
        Lz4Util.createFile(compressByte, cellFilePath);
        byte[] decompressor = Lz4Util.lz4Decompress(compressByte, srcByte.length);

//        Lz4Util.createFile(decompressor, cellFilePath);
    }

    private static void createFile(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    public static byte[] compress(byte[] srcBytes) throws IOException {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        LZ4Compressor compressor = factory.fastCompressor();
        LZ4BlockOutputStream compressedOutput = new LZ4BlockOutputStream(
                byteOutput, 2048, compressor);
        compressedOutput.write(srcBytes);
        compressedOutput.close();
        return byteOutput.toByteArray();
    }

    public static byte[] decompressor(byte[] bytes) throws IOException {
        LZ4Factory factory = LZ4Factory.fastestInstance();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        LZ4FastDecompressor decompresser = factory.fastDecompressor();
        LZ4BlockInputStream lzis = new LZ4BlockInputStream(
                new ByteArrayInputStream(bytes), decompresser);
        int count;
        byte[] buffer = new byte[2048];
        while ((count = lzis.read(buffer)) != -1) {
            baos.write(buffer, 0, count);
        }
        lzis.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        compressFile();
//        byte[] srcByte = new byte[9000000];
//        for (int i = 0; i < 9000000; i++) {
//            srcByte[i] = 'a';
//        }
//        long startTime = System.currentTimeMillis();
//
//        System.out.println(" srcByte.length= " + srcByte.length);
//        byte[] cB = lz4Util.lz4Compress(srcByte, 1024);
//        System.out.println("  cB.length= " + cB.length);
//        byte[] db = lz4Util.lz4Decompress(cB, 1024);
//        System.out.println(" db.length= " + db.length);
//
//        long endTime = System.currentTimeMillis();
//        System.out.println(" endTime-startTime=" + (endTime - startTime));
//        test1();

    }

    /**
     * //lz4压缩
     */
    public static void test1() {
        LZ4Factory factory = LZ4Factory.fastestInstance();

        byte[] data = "123456789jjjjjjjjjjjjjjjjjjjjjjjjfddjjjjjjjjjjjjjjjjjjjdddddjjjjjjjjjdjjjjjjfjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj".getBytes();
        int decompressedLength = data.length;
        System.out.println("  decompressedLength=" + decompressedLength);

        //compress
        LZ4Compressor compressor = factory.fastCompressor();

        int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);
        byte[] temp = compressor.compress(data);
        System.out.println("  temp.length= " + temp.length);
        System.out.println("   compressed.length= " + compressed.length);


        //decompress  when the decompressed length is known
        LZ4FastDecompressor decompressor = factory.fastDecompressor();
        byte[] restored = new byte[decompressedLength];
        int compressedLength2 = decompressor.decompress(compressed, 0, restored, 0, decompressedLength);

        System.out.println(" restored.length=" + restored.length);
        //decompress method 2  when the compressed length is known (a little slower)
        LZ4SafeDecompressor decompressor2 = factory.safeDecompressor();
        int decompressedLength2 = decompressor2.decompress(compressed, 0, compressedLength, restored, 0);
    }

}
