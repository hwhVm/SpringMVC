package com.beini.test.javase.compress;

import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * Created by beini on 2017/10/30.
 */
public class SnappyUtil {

    //snappy 压缩
    public static byte[] snappyCompress(byte[] data) throws IOException {
        return Snappy.compress(data);
    }

    public static byte[] snappyDecompress(byte[] data) throws IOException {
        return Snappy.uncompress(data);
    }
}
