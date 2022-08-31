package com.dctmz.util;

import java.util.Date;

/**
 * @author dctxf
 */
public class DateUtils {
    public static Date addMillisecond(long millisecond) {
        long currentTime = System.currentTimeMillis();
        currentTime += millisecond * 1000;
        return new Date(currentTime);
    }
}
