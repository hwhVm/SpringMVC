package com.beini.test.javase.compress;


import net.jpountz.lz4.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by beini on 2017/10/28.
 */
public class CompressTest {
    /**
     * 压缩：Google  Snappy ,https://github.com/xerial/snappy-java
     * zlib
     * lz4:https://github.com/lz4/lz4-java
     * java 自带的：
     * <p>
     * JDK GZIP:压缩比高的慢速算法，压缩后的数据适合长期使用。JDK中的java.util.zip.GZIPInputStream / GZIPOutputStream便是这个算法的实现。
     * <p>
     * , JDK deflate:
     * 这是JDK中的又一个算法（zip文件用的就是这一算法）。它与gzip的不同之处在于，你可以指定算法的压缩级别，这样你可以在压缩时间和输出文件大小上进行平衡。可选的级别有0（不压缩），以及1(快速压缩)到9（慢速压缩）。
     * http://www.findsrc.com/columnist/detail/8638
     */

    public static void main(String[] args) throws IOException {
        compressFile();
    }

    //文件压缩
    public static void compressFile() throws IOException {
        String filePath = "D:/demo/aa.pdf";
        String cellFilePath = "D:/demo/copy/aa.zip";
        FileInputStream fileInputStream;
        FileOutputStream filefOutputStream;

        byte[] bufferByte = new byte[10 * 1024 * 1024];//10 M
        int len;
        fileInputStream = new FileInputStream(filePath);
        filefOutputStream = new FileOutputStream(cellFilePath);
        LZ4Factory factory = LZ4Factory.fastestInstance();

        LZ4Compressor compressor = factory.fastCompressor();
        LZ4FastDecompressor decompresser = factory.fastDecompressor();

        LZ4BlockInputStream lz4BlockInputStream = new LZ4BlockInputStream(fileInputStream, decompresser);
        LZ4BlockOutputStream lz4BlockOutputStream = new LZ4BlockOutputStream(filefOutputStream);

        while ((len = lz4BlockInputStream.read(bufferByte)) != -1) {
            System.out.println("   -------------- ");
            lz4BlockOutputStream.write(bufferByte, 0, len);
        }
//        lz4BlockOutputStream.flush();
        lz4BlockOutputStream.close();
        lz4BlockInputStream.close();
    }

    /**
     * //lz4压缩
     * public static byte[] lz4Compress(byte[] data) throws IOException {
     * LZ4Factory factory = LZ4Factory.fastestInstance();
     * ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
     * LZ4Compressor compressor = factory.fastCompressor();
     * LZ4BlockOutputStream compressedOutput = new LZ4BlockOutputStream(byteOutput, 8192, compressor);
     * compressedOutput.write(data);
     * compressedOutput.close();
     * return byteOutput.toByteArray();
     * }
     */
    public void test1() {
        LZ4Factory factory = LZ4Factory.fastestInstance();

        byte[] data = "123456789jjjjjjjjjjjjjjjjjjjjjjjjfddjjjjjjjjjjjjjjjjjjjdddddjjjjjjjjjdjjjjjjfjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj".getBytes();
        int decompressedLength = data.length;
        System.out.println("  decompressedLength=" + decompressedLength);
        //compress
        LZ4Compressor compressor = factory.fastCompressor();
        int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);
        System.out.println("  compressedLength= " + compressedLength);
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
