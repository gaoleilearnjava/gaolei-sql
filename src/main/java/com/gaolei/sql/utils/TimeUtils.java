package com.gaolei.sql.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/11 10:16
 */
public class TimeUtils {
    public static String getTime() {
        //设置产品创建时间
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        String time = dateFormat.format(date);
        return time;
    }
}
