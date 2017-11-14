package com.beini.test.javase.strem.io;


import java.io.*;

/**
 * Created by beini on 2017/11/11.
 */
public class IoUtil {
    /**
     * 字符流
     *
     * @param filePath
     */
    public static void copyByPrintReader(String filePath, String destString) {
        PrintWriter out;
        try {
            out = new PrintWriter(
                    new BufferedWriter(new FileWriter(destString)));

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String s = bufferedReader.readLine();
            while (s != null) {
                System.out.println("  s = " + s);
                out.println(s);
                out.flush();
                s = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流
     *
     * @param filePath
     */
    public static void readTextContent(String filePath) {
        InputStream inputStream;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(filePath)));

            byte[] bufferByte = new byte[1024];
            int nextBytes = inputStream.read(bufferByte);
            System.out.println("       nextBytes=" + nextBytes);
            while (nextBytes != -1) {
                for (int i = 0; i < nextBytes; i++) {
                    System.out.print((char) bufferByte[i]);
                }
                nextBytes = inputStream.read(bufferByte);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String strPath, String destPath) {
        InputStream inputStream;
        OutputStream outputStream;
        try {
            File file = new File(strPath);
            outputStream = new BufferedOutputStream(new FileOutputStream(new File(destPath)));
            inputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bufferByte = new byte[(int) file.length()];//文件不能超过2g
            int nextBytes = inputStream.read(bufferByte);

            while (nextBytes != -1) {
                outputStream.write(bufferByte, 0, nextBytes);
                nextBytes = inputStream.read(bufferByte);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param strPath
     * @param destPath
     * @param startSize
     * @param len
     */
    public static void cutOutFile(String strPath, String destPath, int startSize, int len) {
        InputStream inputStream;
        OutputStream outputStream;
        try {
            File fileStr = new File(strPath);
            File fileDest = new File(destPath);

            outputStream = new BufferedOutputStream(new FileOutputStream(fileDest));
            inputStream = new BufferedInputStream(new FileInputStream(fileStr));
            byte[] bufferByte = new byte[(int) fileStr.length()];//文件不能超过2g
            inputStream.read(bufferByte, startSize, len);
            outputStream.write(bufferByte, 0, len);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
