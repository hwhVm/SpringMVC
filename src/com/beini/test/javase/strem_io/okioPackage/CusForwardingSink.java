package com.beini.test.javase.strem_io.okioPackage;

import okio.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by beini on 2017/11/9.
 */
public class CusForwardingSink extends ForwardingSink {
    private long bytesWritten = 0;
    private SinkListen sinkListen;
    private File file;
    private long totalLength;

    public CusForwardingSink(Sink delegate, File file, SinkListen sinkListen) {
        super(delegate);
        this.file = file;
        this.sinkListen = sinkListen;
        this.totalLength = contentLength();
    }

    public long contentLength() {
        if (file != null) {
            return file.length();
        } else {
            return 0;
        }
    }

    @Override
    public void write(Buffer source, long byteCount) throws IOException {

        super.write(source, byteCount);
        bytesWritten += byteCount;
        sinkListen.onProgress(bytesWritten, totalLength);
        //


    }


}
