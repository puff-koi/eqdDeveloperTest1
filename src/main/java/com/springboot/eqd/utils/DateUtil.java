package com.springboot.eqd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String dateToString(Date date){
        return sdf.format(date);
    }
}
