package com.beini.test.javase.pattern.prototypePattern;


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;

/**
 * Created by beini on 2018/2/6.
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * 它主要面对的问题是：“某些结构复杂的对象”的创建工作；由于需求的变化，这些对象经常面临着剧烈的变化，但是他们却拥有比较稳定一致的接口。
 * 拷贝是不执行构造函数
 */
public class Test<T> {
    private static int num = 20000000;

    public static void main(String[] arg) throws CloneNotSupportedException {
        Mail mail = new Mail("beini");

        Mail mailClone = mail.clone();
        System.out.println(" ==" + (mail == mailClone));
        System.out.println("equals " + mail.equals(mailClone));
//        System.out.println(" 1 " + mailClone.getTitle());
//        mail.setTitle("larry");
//        System.out.println("2 " + mailClone.getTitle());
//        System.out.println("3 " + mail.getTitle());

    }

    public static void Test1() {
//        long startTime = System.currentTimeMillis();
//        Mail mail;
//        for (int i = 0; i < num; i++) {
//            mail = new Mail();
//            mail.setTitle("no let the younth  wationg for");
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(" endTime - startTime=" + (endTime - startTime));
    }

    public static void Test2() throws CloneNotSupportedException {
//        long startTime = System.currentTimeMillis();
//        Mail mail = new Mail();
//        Mail mailClone;
//        for (int i = 0; i < num; i++) {
//            mailClone = mail.clone();
//            mailClone.setTitle("no let the younth  wationg for");
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(" endTime - startTime=" + (endTime - startTime));
    }

    public T cloneTo(T src) throws RuntimeException {
        ByteArrayOutputStream memoryBuffer = new ByteArrayOutputStream();
        ObjectOutputStream out;
        ObjectInputStream in;
        T dist;
        try {
            out = new ObjectOutputStream(memoryBuffer);
            out.writeObject(src);
            out.flush();
            in = new ObjectInputStream(new ByteArrayInputStream(memoryBuffer.toByteArray()));
            dist = (T) in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dist;

    }

}
