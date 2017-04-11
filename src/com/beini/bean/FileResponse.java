package com.beini.bean;

/**
 * Created by beini on 2016/10/20.
 */

public class FileResponse {
    /**
     * "errorcode":0,
     * "errormsg":"",
     * "FileId":"group1/M00/00/02/LU9cx1f_K0eADfaFAACOcWdDeqE258.jpg"
     */
    public int errorcode;
    public String errormsg;
    public String FileId;

    public String getFileId() {
        return FileId;
    }

    public FileResponse setFileId(String fileId) {
        FileId = fileId;
        return this;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public FileResponse setErrormsg(String errormsg) {
        this.errormsg = errormsg;
        return this;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public FileResponse setErrorcode(int errorcode) {
        this.errorcode = errorcode;
        return this;
    }

}
