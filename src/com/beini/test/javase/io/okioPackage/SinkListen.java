package com.beini.test.javase.io.okioPackage;

/**
 * Created by beini on 2017/11/9.
 */
public interface SinkListen {
    void onProgress(long bytesWritten, long contentLength);
}
