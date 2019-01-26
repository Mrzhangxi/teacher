package com.zx.teachers.Utils;

import com.zx.teachers.Exception.TeacherException;
import com.zx.teachers.enums.UtilsEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 将格式化的字符串时间转为标准的Date类型时间
     * @param sdate
     * @return
     */
    public static Date stringToDate(String sdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(sdate);
        } catch (ParseException e) {
            throw new TeacherException(UtilsEnum.DATE_PRASE_ERROR);
        }
    }

    /**
     * 将标准的Date类型时间转为格式化的字符串时间
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
