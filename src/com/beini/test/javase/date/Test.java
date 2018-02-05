package com.beini.test.javase.date;

import com.beini.utils.BLog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by beini on 2018/2/2.
 */
public class Test {

    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date d1 = df.parse("2018-03-26 13:31:40");
            Date d2 = df.parse("2018-01-02 13:31:40");
            long diff = d1.getTime() - d2.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            BLog.d("days=" + days);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
