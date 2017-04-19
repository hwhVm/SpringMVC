package com.beini.utils;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/2/22.
 */
public class BLog {
    private static Logger logger = Logger.getLogger(BLog.class);

    public static void d(String string) {
        logger.error("------------>" + string);
    }
}
